package com.tencent.mobileqq.activity.contacts.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contacts.base.CommonCardEntry;
import com.tencent.mobileqq.activity.contacts.view.card.CardChildView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import wrv;
import wrw;

public class HeadCardAdapter
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
  private HeadCardAdapter.HeadAdapterCallback jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter$HeadAdapterCallback;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new wrv(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  protected FaceDecoder a;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  
  public HeadCardAdapter(QQAppInterface paramQQAppInterface, Context paramContext, HeadCardAdapter.HeadAdapterCallback paramHeadAdapterCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter$HeadAdapterCallback = paramHeadAdapterCallback;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    a(ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false));
  }
  
  private void a(CommonCardEntry paramCommonCardEntry, View paramView)
  {
    int i = 0;
    TextView localTextView1 = (TextView)paramView.findViewById(2131363397);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362724);
    TextView localTextView2 = (TextView)paramView.findViewById(2131363062);
    TextView localTextView3 = (TextView)paramView.findViewById(2131363598);
    TextView localTextView4 = (TextView)paramView.findViewById(2131363881);
    localImageView.setImageResource(paramCommonCardEntry.jdField_b_of_type_Int);
    localTextView1.setText(paramCommonCardEntry.jdField_a_of_type_JavaLangString);
    localTextView2.setText(paramCommonCardEntry.jdField_b_of_type_JavaLangString);
    localTextView3.setText(paramCommonCardEntry.c);
    if (paramCommonCardEntry.jdField_a_of_type_Int == 1) {}
    for (boolean bool1 = ConfessConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_contact_show");; bool1 = false)
    {
      boolean bool2;
      if (localTextView4.getVisibility() == 0)
      {
        bool2 = true;
        if (bool1 != bool2) {
          if (!bool1) {
            break label175;
          }
        }
      }
      for (;;)
      {
        localTextView4.setVisibility(i);
        paramView = paramView.findViewById(2131363878);
        paramView.setOnClickListener(this);
        paramView.setTag(2131363878, paramCommonCardEntry);
        paramView.setBackgroundResource(this.jdField_a_of_type_Int);
        return;
        bool2 = false;
        break;
        label175:
        i = 8;
      }
    }
  }
  
  private void a(MayKnowRecommend paramMayKnowRecommend, View paramView)
  {
    Object localObject1 = (ImageView)paramView.findViewById(2131363871);
    TextView localTextView3 = (TextView)paramView.findViewById(2131363873);
    TextView localTextView4 = (TextView)paramView.findViewById(2131363874);
    TextView localTextView1 = (TextView)paramView.findViewById(2131363875);
    TextView localTextView2 = (TextView)paramView.findViewById(2131363876);
    Object localObject2 = (TextView)paramView.findViewById(2131363877);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131363872);
    View localView = paramView.findViewById(2131363869);
    localView.setOnClickListener(this);
    localView.setTag(2131363869, paramMayKnowRecommend);
    localView.setBackgroundResource(this.jdField_a_of_type_Int);
    ((ImageView)localObject1).setImageBitmap(a(1, paramMayKnowRecommend.uin));
    ((TextView)localObject2).setOnClickListener(this);
    ((TextView)localObject2).setTag(paramMayKnowRecommend);
    label266:
    int j;
    int i;
    if (paramMayKnowRecommend.friendStatus == 0)
    {
      localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838672));
      ((TextView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838565));
      ((TextView)localObject2).setText(2131433047);
      ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433047) + "按钮");
      int k = paramMayKnowRecommend.age;
      localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      if (!TextUtils.isEmpty(paramMayKnowRecommend.remark)) {
        break label605;
      }
      if (!TextUtils.isEmpty(paramMayKnowRecommend.nick)) {
        break label597;
      }
      paramView = paramMayKnowRecommend.uin;
      localTextView3.setText(paramView);
      if ((AppSetting.b) && (!TextUtils.isEmpty(paramView)))
      {
        ((StringBuilder)localObject1).append("推荐好友");
        ((StringBuilder)localObject1).append(paramView);
      }
      switch (paramMayKnowRecommend.gender)
      {
      default: 
        j = 0;
        localTextView4.setBackgroundResource(2130843152);
        i = 0;
        label341:
        if (paramMayKnowRecommend.age > 0)
        {
          i = 1;
          ((StringBuilder)localObject2).append(k).append("岁");
          localTextView4.setText(String.valueOf(k));
          label374:
          if (i == 0) {
            break label678;
          }
          localTextView4.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
          localTextView4.setVisibility(0);
          localTextView4.setPadding(8, 4, 8, 4);
          if (AppSetting.b) {
            ((StringBuilder)localObject1).append((CharSequence)localObject2);
          }
          paramView = new StringBuilder();
          if (!TextUtils.isEmpty(paramMayKnowRecommend.category)) {
            paramView.append(paramMayKnowRecommend.category).append(" ");
          }
          if (!TextUtils.isEmpty(paramMayKnowRecommend.recommendReason)) {
            paramView.append(paramMayKnowRecommend.recommendReason);
          }
          paramView = paramView.toString();
          if (TextUtils.isEmpty(paramView)) {
            break label688;
          }
          localTextView1.setVisibility(0);
          localTextView1.setText(paramView);
        }
        label419:
        break;
      }
    }
    for (;;)
    {
      if (AppSetting.b) {
        localView.setContentDescription(((StringBuilder)localObject1).toString());
      }
      a(paramMayKnowRecommend, localTextView2, null);
      return;
      if (paramMayKnowRecommend.friendStatus != 1) {
        break;
      }
      localLinearLayout.setBackgroundDrawable(null);
      ((TextView)localObject2).setBackgroundDrawable(null);
      ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433062));
      ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433062) + "按钮");
      break;
      label597:
      paramView = paramMayKnowRecommend.nick;
      break label266;
      label605:
      paramView = paramMayKnowRecommend.remark;
      break label266;
      i = 1;
      j = 2130843151;
      ((StringBuilder)localObject2).append("男,");
      localTextView4.setBackgroundResource(2130843152);
      break label341;
      i = 1;
      j = 2130843149;
      ((StringBuilder)localObject2).append("女,");
      localTextView4.setBackgroundResource(2130843150);
      break label341;
      localTextView4.setText("");
      break label374;
      label678:
      localTextView4.setVisibility(8);
      break label419;
      label688:
      localTextView1.setVisibility(8);
    }
  }
  
  private void a(MayKnowRecommend paramMayKnowRecommend, TextView paramTextView, Bitmap paramBitmap)
  {
    RichStatus localRichStatus = paramMayKnowRecommend.getRichStatus();
    paramMayKnowRecommend = localRichStatus.toSpannableString(null, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494283), this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494283));
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(512);
      ((StringBuilder)localObject).append("updateRichStatus , status.actionText : ");
      ((StringBuilder)localObject).append(localRichStatus.actionText);
      ((StringBuilder)localObject).append(" , actionId : ");
      ((StringBuilder)localObject).append(localRichStatus.actionId);
      ((StringBuilder)localObject).append(" , status.dataText : " + localRichStatus.dataText);
      ((StringBuilder)localObject).append(" , dataId : ");
      ((StringBuilder)localObject).append(localRichStatus.dataId);
      ((StringBuilder)localObject).append(" , ss : ");
      ((StringBuilder)localObject).append(paramMayKnowRecommend);
      QLog.d("HeadCardAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(localRichStatus.actionText))
    {
      paramTextView.setVisibility(0);
      localObject = new SpannableStringBuilder(paramMayKnowRecommend);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      paramMayKnowRecommend = paramBitmap;
      if (paramBitmap == null) {
        paramMayKnowRecommend = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.actionId, 200);
      }
      paramMayKnowRecommend = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMayKnowRecommend, false, false);
      int i = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramMayKnowRecommend.setBounds(0, 0, i, i);
      paramMayKnowRecommend = new OffsetableImageSpan(paramMayKnowRecommend, 0);
      paramMayKnowRecommend.a(-0.1F);
      ((SpannableStringBuilder)localObject).setSpan(paramMayKnowRecommend, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    if (paramMayKnowRecommend.length() == 0)
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    paramTextView.setText(paramMayKnowRecommend);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((wrw)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == paramInt) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.a();
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    for (wrw localwrw = (wrw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);; localwrw = null)
    {
      if (localwrw != null)
      {
        localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(localwrw.jdField_a_of_type_Int);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label377;
        }
      }
      label377:
      for (localObject = (View)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);; localObject = null)
      {
        switch (localwrw.jdField_a_of_type_Int)
        {
        default: 
          if (QLog.isColorLevel()) {
            QLog.i("HeadCardAdapter", 2, String.format(Locale.getDefault(), "getView undefined data [type: %s, data: %s]", new Object[] { Integer.valueOf(localwrw.jdField_a_of_type_Int), localwrw.jdField_a_of_type_JavaLangObject }));
          }
          if (localObject != null) {
            ((View)localObject).setTag(localwrw);
          }
          return localObject;
        case 2: 
          if (localObject != null) {
            break;
          }
        }
        for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968813, paramViewGroup, false);; paramViewGroup = (ViewGroup)localObject)
        {
          if ((localwrw.jdField_a_of_type_JavaLangObject instanceof MayKnowRecommend))
          {
            a((MayKnowRecommend)localwrw.jdField_a_of_type_JavaLangObject, paramViewGroup);
            localObject = paramViewGroup;
            break;
          }
          localObject = paramViewGroup;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("HeadCardAdapter", 2, String.format(Locale.getDefault(), "getView invalidate data [type: %s, data: %s]", new Object[] { Integer.valueOf(localwrw.jdField_a_of_type_Int), localwrw.jdField_a_of_type_JavaLangObject }));
          localObject = paramViewGroup;
          break;
          if (localObject == null) {}
          for (paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968814, paramViewGroup, false);; paramViewGroup = (ViewGroup)localObject)
          {
            if ((localwrw.jdField_a_of_type_JavaLangObject instanceof CommonCardEntry))
            {
              a((CommonCardEntry)localwrw.jdField_a_of_type_JavaLangObject, paramViewGroup);
              localObject = paramViewGroup;
              break;
            }
            localObject = paramViewGroup;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("HeadCardAdapter", 2, String.format(Locale.getDefault(), "getView invalidate data [type: %s, data: %s]", new Object[] { Integer.valueOf(localwrw.jdField_a_of_type_Int), localwrw.jdField_a_of_type_JavaLangObject }));
            localObject = paramViewGroup;
            break;
          }
        }
      }
    }
  }
  
  public Object a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      wrw localwrw = (wrw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localwrw != null) {
        return localwrw.jdField_a_of_type_JavaLangObject;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          View localView = (View)localIterator.next();
          if ((localView instanceof CardChildView)) {
            localView.setOnClickListener(null);
          }
        }
        localArrayList.clear();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    if (i >= 0)
    {
      wrw localwrw = (wrw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localwrw == null) {}
      for (;;)
      {
        i -= 1;
        break;
        if (localwrw.jdField_a_of_type_Int == paramInt)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localwrw);
          localwrw.a();
        }
      }
    }
  }
  
  public void a(int paramInt1, CommonCardEntry paramCommonCardEntry, int paramInt2)
  {
    a(paramInt1);
    if (paramCommonCardEntry != null)
    {
      paramCommonCardEntry = wrw.a(paramInt1, paramCommonCardEntry);
      paramInt1 = Math.max(0, Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), paramInt2));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt1, paramCommonCardEntry);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, CommonCardEntry paramCommonCardEntry)
  {
    a(paramInt);
    ArrayList localArrayList;
    if (paramCommonCardEntry != null)
    {
      paramCommonCardEntry = wrw.a(paramInt, paramCommonCardEntry);
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (paramInt = 0;; paramInt = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localArrayList.add(paramInt, paramCommonCardEntry);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List paramList)
  {
    a(paramInt);
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramBoolean) {}
      for (int i = 0;; i = this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          wrw localwrw = wrw.a(paramInt, (MayKnowRecommend)paramList.next());
          this.jdField_a_of_type_JavaUtilArrayList.add(i, localwrw);
          i += 1;
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof wrw));
    wrw localwrw = (wrw)localObject;
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(localwrw.jdField_a_of_type_Int);
    Object localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList(2);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localwrw.jdField_a_of_type_Int, localObject);
    }
    ((ArrayList)localObject).add(paramView);
    paramView.setTag(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Int = 2130838670;
    }
    for (;;)
    {
      return;
      String str = ThemeUtil.getCurrentThemeId();
      if ("1103".equals(str)) {}
      for (this.jdField_a_of_type_Int = 2130838671; QLog.isDevelopLevel(); this.jdField_a_of_type_Int = 2130838672)
      {
        QLog.i("HeadCardAdapter", 4, String.format(Locale.getDefault(), "onThemeChanged cur: %s", new Object[] { str }));
        return;
      }
    }
  }
  
  public int b()
  {
    return 3;
  }
  
  public int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      wrw localwrw = (wrw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localwrw != null) {
        return localwrw.jdField_a_of_type_Int;
      }
    }
    return -1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = paramView.getTag(2131363878);
          } while (!(paramView instanceof CommonCardEntry));
          paramView = (CommonCardEntry)paramView;
          if (paramView.jdField_a_of_type_Int == 1)
          {
            if (!TextUtils.isEmpty(paramView.d))
            {
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject).putExtra("hide_more_button", true);
              ((Intent)localObject).putExtra("hide_operation_bar", true);
              ((Intent)localObject).putExtra("url", paramView.d);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 1, 0, "", "", "", "");
          }
          for (;;)
          {
            if (paramView.jdField_a_of_type_Int == 1) {
              ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008F4B", "0X8008F4B", 1, 0, "", "", "", "");
            return;
            if (paramView.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092C7", "0X80092C7", 0, 0, "", "", "", "");
              PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, ExtendFriendFragment.class);
            }
          }
          paramView = paramView.getTag(2131363869);
        } while (!(paramView instanceof MayKnowRecommend));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F15", "0X8007F15", 0, 0, "", "", "", "");
        paramView = (MayKnowRecommend)paramView;
        int j = 82;
        int i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(paramView.uin)) {
            i = 1;
          }
        }
        localObject = new ProfileActivity.AllInOne(paramView.uin, i);
        if (!TextUtils.isEmpty(paramView.remark)) {
          ((ProfileActivity.AllInOne)localObject).l = paramView.remark;
        }
        if (!TextUtils.isEmpty(paramView.nick)) {
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramView.nick;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 88;
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter$HeadAdapterCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter$HeadAdapterCallback.a(true);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007F16", "0X8007F16", 0, 0, "", "", "", "");
      localObject = (MayKnowRecommend)paramView.getTag();
    } while (localObject == null);
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((MayKnowRecommend)localObject).uin)) && (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(((MayKnowRecommend)localObject).uin)))
    {
      if (TextUtils.isEmpty(((MayKnowRecommend)localObject).remark)) {
        if (TextUtils.isEmpty(((MayKnowRecommend)localObject).nick)) {
          paramView = ((MayKnowRecommend)localObject).uin;
        }
      }
      for (;;)
      {
        paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject).uin, null, 3045, 9, paramView, null, SplashActivity.class.getName(), this.jdField_a_of_type_AndroidContentContext.getString(2131435242), null);
        paramView.putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject).gender, ((MayKnowRecommend)localObject).age, ((MayKnowRecommend)localObject).country, ((MayKnowRecommend)localObject).province, ((MayKnowRecommend)localObject).city));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        return;
        paramView = ((MayKnowRecommend)localObject).nick;
        continue;
        paramView = ((MayKnowRecommend)localObject).remark;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((MayKnowRecommend)localObject).uin))
    {
      ((MayKnowRecommend)localObject).friendStatus = 2;
      return;
    }
    ((MayKnowRecommend)localObject).friendStatus = 1;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterHeadCardAdapter$HeadAdapterCallback.a();
      paramInt1 = 0;
      if (paramInt1 < paramBitmap.size())
      {
        Object localObject = (View)paramBitmap.get(paramInt1);
        if (localObject == null) {}
        label159:
        for (;;)
        {
          paramInt1 += 1;
          break;
          if ((((View)localObject).getTag() instanceof wrw)) {}
          for (paramString = (wrw)((View)localObject).getTag();; paramString = null)
          {
            if ((paramString == null) || (!(paramString.jdField_a_of_type_JavaLangObject instanceof MayKnowRecommend))) {
              break label159;
            }
            paramString = (MayKnowRecommend)paramString.jdField_a_of_type_JavaLangObject;
            paramString = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.uin);
            if (paramString == null) {
              break;
            }
            localObject = (ImageView)((View)localObject).findViewById(2131363871);
            if (localObject == null) {
              break;
            }
            ((ImageView)localObject).setImageBitmap(paramString);
            break;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.HeadCardAdapter
 * JD-Core Version:    0.7.0.1
 */