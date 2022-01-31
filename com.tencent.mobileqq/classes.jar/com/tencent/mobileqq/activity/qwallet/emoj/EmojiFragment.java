package com.tencent.mobileqq.activity.qwallet.emoj;

import aiyl;
import alud;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import bayu;
import bdnn;
import bjcf;
import bjcm;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class EmojiFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private static final String SP_KEY_NAME = "is_first_in";
  private static final String SP_NAME = "red_packet";
  private static final String TAG = "EmojiFragment";
  int availableRight = 0;
  public EmojiFragment.TemplateBundleInfo bundleInfo = new EmojiFragment.TemplateBundleInfo();
  public Button confirm;
  public int currSkinId;
  public int currentTempId = -1;
  public String currentWish;
  public EmoticonTemplateRecyclerView emoticonTemplateRecyclerView;
  private SparseArray<ImageView> imgViewSparseArray = new SparseArray();
  public EditText mAmoutTxt;
  public EmojiRedpacketUserGuideDialog mPopupWindow;
  public ImageView mPrefImageView;
  private String mTempId;
  private List<EmojiFragment.TemplateInfo> mTemplateBundleInfos;
  protected TextWatcher mTextWatcher = new EmojiFragment.1(this);
  public long mlastInvalidatetime;
  public EditText numTxt;
  private EmojiFragment.TemplateInfo preTemplateInfo;
  public View rootView;
  private SparseArray<URLDrawable> urlDrawableSparseArray = new SparseArray();
  
  private List<EmojiFragment.TemplateInfo> initData(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    EmojiFragment.TemplateInfo localTemplateInfo = null;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject;
        if (bdnn.a(paramString1))
        {
          localJSONObject = getHbPannelConfig(8);
          paramString1 = localTemplateInfo;
          if (localJSONObject != null)
          {
            paramString1 = localJSONObject.optJSONArray("heartList");
            paramString2 = localJSONObject.optString("prefix");
            break label234;
            if (paramString1 == null) {
              break label237;
            }
            if (paramString1.length() != 0) {
              break label240;
            }
            break label237;
          }
        }
        else
        {
          paramString1 = new JSONArray(paramString1);
          continue;
          if (i < paramString1.length())
          {
            localTemplateInfo = new EmojiFragment.TemplateInfo();
            localTemplateInfo.index = i;
            localJSONObject = paramString1.optJSONObject(i);
            if (localJSONObject != null)
            {
              localTemplateInfo.rId = localJSONObject.optInt("rId");
              localTemplateInfo.skinId = localJSONObject.optInt("skinId");
              localTemplateInfo.text = localJSONObject.optString("text");
              localTemplateInfo.url = (paramString2 + localTemplateInfo.rId + ".png");
              localArrayList.add(localTemplateInfo);
            }
            i += 1;
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmojiFragment", 1, "init emoji template data throw an exception: " + paramString1);
        }
      }
      label234:
      continue;
      label237:
      return localArrayList;
      label240:
      int i = 0;
    }
  }
  
  private void initView(View paramView, Bundle paramBundle)
  {
    try
    {
      bjcm.a(paramBundle, this.bundleInfo);
      paramView.findViewById(2131368959).setOnClickListener(this);
      this.emoticonTemplateRecyclerView = ((EmoticonTemplateRecyclerView)paramView.findViewById(2131377521));
      paramBundle = new EmojiFragment.TemplateListAdapter(this, this.mActivity);
      this.mTemplateBundleInfos = initData(this.bundleInfo.heartList, this.bundleInfo.prefix);
      paramBundle.addTempList(this.mTemplateBundleInfos);
      this.emoticonTemplateRecyclerView.setAdapter(paramBundle);
      this.emoticonTemplateRecyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 4, 1, false));
      paramBundle = new EmojiFragment.TempGridItemLayoutDecoration(this, this.mActivity, 4);
      this.emoticonTemplateRecyclerView.addItemDecoration(paramBundle);
      this.mAmoutTxt = ((EditText)paramView.findViewById(2131362556));
      this.mAmoutTxt.addTextChangedListener(this.mTextWatcher);
      this.numTxt = ((EditText)paramView.findViewById(2131371312));
      if (bjcm.b.contains(this.bundleInfo.recv_type))
      {
        this.numTxt.setText("1");
        paramView.findViewById(2131378240).setVisibility(8);
      }
      for (;;)
      {
        if ((this.mTemplateBundleInfos != null) && (this.mTemplateBundleInfos.size() > 0)) {
          setSelected((EmojiFragment.TemplateInfo)this.mTemplateBundleInfos.get(0));
        }
        paramBundle = this.bundleInfo.biz_params;
        if (!bdnn.a(paramBundle)) {
          this.mTempId = new JSONObject(paramBundle).optString("temp_id");
        }
        if (!bdnn.a(this.mTempId)) {
          processDefaultTmpException(this.mTempId);
        }
        this.confirm = ((Button)paramView.findViewById(2131364689));
        this.confirm.setOnClickListener(this);
        freshConfirmBtn();
        return;
        if (!TextUtils.isEmpty(this.bundleInfo.people_num)) {
          this.numTxt.setHint(alud.a(2131704403) + this.bundleInfo.people_num + alud.a(2131704404));
        }
        this.numTxt.addTextChangedListener(this.mTextWatcher);
      }
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void processDefaultTmpException(String paramString)
  {
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        paramString = this.mTemplateBundleInfos.iterator();
        if (paramString.hasNext())
        {
          EmojiFragment.TemplateInfo localTemplateInfo = (EmojiFragment.TemplateInfo)paramString.next();
          if (i != localTemplateInfo.rId) {
            continue;
          }
          setSelected(localTemplateInfo);
          i = 1;
          if (i == 0) {
            QQToast.a(getActivity(), 2131697163, 0).a();
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("EmojiFragment", 1, "processDefaultTmpSelected occur an exception: " + paramString);
        QQToast.a(getActivity(), 2131697163, 0).a();
        return;
      }
      int i = 0;
    }
  }
  
  private void setDefaultTempSelected(EmojiFragment.TemplateInfo paramTemplateInfo, String paramString, ImageView paramImageView)
  {
    try
    {
      if ((Integer.parseInt(paramString) == paramTemplateInfo.rId) && (paramImageView != null)) {
        onTempSelected(paramTemplateInfo, paramImageView);
      }
      return;
    }
    catch (Exception paramTemplateInfo)
    {
      QLog.e("EmojiFragment", 1, "processDefaultTmpSelected occur an exception: " + paramTemplateInfo);
    }
  }
  
  private void setSelected(EmojiFragment.TemplateInfo paramTemplateInfo)
  {
    if (this.mTemplateBundleInfos != null)
    {
      int i = 0;
      if (i < this.mTemplateBundleInfos.size())
      {
        EmojiFragment.TemplateInfo localTemplateInfo = (EmojiFragment.TemplateInfo)this.mTemplateBundleInfos.get(i);
        if (localTemplateInfo.rId == paramTemplateInfo.rId) {}
        for (localTemplateInfo.isSelected = true;; localTemplateInfo.isSelected = false)
        {
          i += 1;
          break;
        }
      }
    }
    if (this.preTemplateInfo != null) {
      handleDrawableSucc((URLDrawable)this.urlDrawableSparseArray.get(this.preTemplateInfo.rId), false, this.preTemplateInfo.rId, (ImageView)this.imgViewSparseArray.get(this.preTemplateInfo.rId));
    }
    if (paramTemplateInfo != null) {
      handleDrawableSucc((URLDrawable)this.urlDrawableSparseArray.get(paramTemplateInfo.rId), true, paramTemplateInfo.rId, (ImageView)this.imgViewSparseArray.get(paramTemplateInfo.rId));
    }
    this.preTemplateInfo = paramTemplateInfo;
  }
  
  public void freshConfirmBtn()
  {
    if (this.confirm == null) {
      return;
    }
    Object localObject = this.numTxt.getText().toString();
    String str = this.mAmoutTxt.getText().toString();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str)) || (this.currentTempId == -1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      QLog.i("EmojiFragment", 2, "info is not complete...");
      this.confirm.setEnabled(false);
      this.confirm.setText(getString(2131697240));
      return;
    }
    if ((bjcf.a((String)localObject) <= 0.0F) || (bjcf.a(str) <= 0.0F))
    {
      this.confirm.setEnabled(false);
      this.confirm.setText(getString(2131697240));
      return;
    }
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(getString(2131697240));
    ((StringBuffer)localObject).append(str);
    ((StringBuffer)localObject).append("元");
    this.confirm.setText(((StringBuffer)localObject).toString());
    this.confirm.setEnabled(true);
  }
  
  public void handleDrawableSucc(URLDrawable paramURLDrawable, boolean paramBoolean, int paramInt, ImageView paramImageView)
  {
    if (paramURLDrawable == null) {}
    do
    {
      Bundle localBundle;
      do
      {
        return;
        localBundle = new Bundle();
        localBundle.putBoolean("key_play_apng", paramBoolean);
        localObject = paramURLDrawable.getURL().getFile();
        paramURLDrawable = (URLDrawable)localObject;
        if (((String)localObject).startsWith(File.separator)) {
          paramURLDrawable = ((String)localObject).substring(1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("EmojiFragment", 2, "thread name: " + Thread.currentThread().getName());
        }
      } while (paramImageView == null);
      Object localObject = QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, bayu.a, bayu.a, localBundle);
      paramImageView.setImageDrawable((Drawable)localObject);
      this.urlDrawableSparseArray.put(paramInt, localObject);
    } while (!paramBoolean);
    paramImageView = new Bundle();
    paramImageView.putBoolean("key_play_apng", false);
    ThreadManager.excute(new EmojiFragment.2(this, QWalletPicHelper.getNetDrawableForQWallet(paramURLDrawable, bayu.a, bayu.a, paramImageView)), 16, null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364689: 
      onConfirmClick();
      return;
    }
    showUserGuid();
  }
  
  public void onConfirmClick()
  {
    this.mActivity.c("phiz.wrappacket.wrap");
    long l = System.currentTimeMillis();
    if (this.mlastInvalidatetime + 1000L > l) {
      return;
    }
    this.mlastInvalidatetime = l;
    String str1 = this.numTxt.getText().toString();
    String str2 = this.mAmoutTxt.getText().toString();
    Map localMap = this.mActivity.a();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.currentWish);
    localMap.put("feedsid", String.valueOf(this.currentTempId));
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", bjcf.a(str2));
    localMap.put("channel", this.channel + "");
    localMap.put("skin_id", this.currSkinId + "");
    this.mLogic.a(localMap);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity.getWindow().setSoftInputMode(32);
    this.rootView = paramLayoutInflater.inflate(2131561705, null);
    initView(this.rootView, getArguments());
    return this.rootView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.urlDrawableSparseArray != null) {
      this.urlDrawableSparseArray.clear();
    }
    if (this.imgViewSparseArray != null) {
      this.imgViewSparseArray.clear();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ThreadManager.getUIHandler().post(new EmojiFragment.3(this));
  }
  
  public void onTempSelected(EmojiFragment.TemplateInfo paramTemplateInfo, ImageView paramImageView)
  {
    this.currentTempId = paramTemplateInfo.rId;
    this.currentWish = paramTemplateInfo.text;
    this.currSkinId = paramTemplateInfo.skinId;
    freshConfirmBtn();
    if (this.mPrefImageView == paramImageView) {
      return;
    }
    paramImageView.setBackgroundResource(2130842960);
    if (this.mPrefImageView != null) {
      this.mPrefImageView.setBackgroundDrawable(null);
    }
    this.mPrefImageView = paramImageView;
    setSelected(paramTemplateInfo);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("EmojiFragment", 2, "phiz redpacket enter...");
      if (this.mActivity != null) {
        this.mActivity.c("phiz.wrappacket.show");
      }
    }
  }
  
  public void showUserGuid()
  {
    if (this.mPopupWindow == null) {
      this.mPopupWindow = new EmojiRedpacketUserGuideDialog(this.mActivity);
    }
    for (;;)
    {
      this.mPopupWindow.show();
      return;
      if (this.mPopupWindow.isShowing()) {
        this.mPopupWindow.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment
 * JD-Core Version:    0.7.0.1
 */