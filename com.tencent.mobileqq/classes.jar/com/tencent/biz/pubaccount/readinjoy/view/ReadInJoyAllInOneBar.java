package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mke;
import mkf;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class ReadInJoyAllInOneBar
  extends LinearLayout
  implements View.OnClickListener
{
  public static final String a;
  private int jdField_a_of_type_Int = 999;
  private long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
  ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback = new mke(this);
  private ReadInJoyAllInOneBar.OnAllInOnEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener;
  protected HttpWebCgiAsyncTask.Callback a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private gallery.GalleryInfo jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public ImageView b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + ReadInJoyAllInOneBar.class.getSimpleName();
  }
  
  public ReadInJoyAllInOneBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new mkf(this);
  }
  
  public ReadInJoyAllInOneBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new mkf(this);
    a(paramContext);
    LayoutInflater.from(paramContext).inflate(a(), this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364039);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364040));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364042));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364043));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364041));
    a(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.jdField_b_of_type_AndroidWidgetImageView);
    a(this.jdField_c_of_type_AndroidWidgetImageView);
    setVisibility(8);
  }
  
  private void a(Context paramContext)
  {
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int m = getPaddingLeft();
    int n = getPaddingRight();
    int i = j;
    if (j == 0) {
      i = DisplayUtil.a(paramContext, 8.0F);
    }
    j = k;
    if (k == 0) {
      j = DisplayUtil.a(paramContext, 10.0F);
    }
    k = m;
    if (m == 0) {
      k = DisplayUtil.a(paramContext, 12.0F);
    }
    m = n;
    if (n == 0) {
      m = DisplayUtil.a(paramContext, 12.0F);
    }
    setPadding(k, i, m, j);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("article_id", "" + this.jdField_b_of_type_JavaLangString);
    localBundle.putString("comment_val", "" + paramString);
    localBundle.putInt("type", 1);
    localBundle.putInt("src", 10);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("anonymous", i);
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject).getManager(2);
      paramString = ((QQAppInterface)localObject).getAccount();
      localObject = localTicketManager.getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
      localBundle.putString("Cookie", "uin=o" + paramString + "; skey=" + (String)localObject);
      localBundle.putInt("PostBodyType", 1);
      paramString = new HashMap();
      paramString.put("BUNDLE", localBundle);
      paramString.put("CONTEXT", getContext().getApplicationContext());
      new HttpWebCgiAsyncTask("https://c.mp.qq.com/cgi-bin/comment/NewComment", "POST", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1000, null, true).a(paramString);
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener.a(paramBoolean);; bool = false)
    {
      if (bool) {
        return;
      }
      if (paramBoolean)
      {
        a();
        QQToast.a(getContext(), 2, "评论成功", 0).a();
        return;
      }
      QQToast.a(getContext(), 1, "评论失败", 0).a();
      return;
    }
  }
  
  public int a()
  {
    return 2130968840;
  }
  
  public void a()
  {
    if (((this.jdField_c_of_type_Int & 0x1) != 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo != null)) {
      ReadInJoyAtlasManager.a().a(this.jdField_b_of_type_JavaLangString + "", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_gallery_url.get().toStringUtf8(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
    }
    if ((this.jdField_c_of_type_Int & 0x2) != 0)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_b_of_type_JavaLangString);
      ReadInJoyAtlasManager.a().a(localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
    }
  }
  
  public void a(int paramInt1, Intent paramIntent, String paramString1, long paramLong, String paramString2, int paramInt2)
  {
    if (paramIntent == null) {
      return;
    }
    PublicAccountReportUtils.a(null, "", "0X8008FE8", "0X8008FE8", 0, 0, "", "", "", GalleryReportedUtils.b(getContext(), paramString1, paramInt2, paramLong, paramString2), false);
    paramIntent = paramIntent.getStringExtra("arg_result_json");
    if (paramInt1 == -1) {}
    label238:
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramIntent);
        paramIntent = paramString1.optString("comment");
        if (TextUtils.isEmpty(paramIntent)) {
          break label238;
        }
        paramIntent = new String(Base64Util.decode(paramIntent.getBytes(), 0));
        boolean bool = paramString1.optBoolean("anonymous");
        if (paramString1.optInt("biuAfterComment") == 1)
        {
          paramInt1 = 1;
          a(paramIntent, bool);
          if (paramInt1 != 0) {
            ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_b_of_type_JavaLangString, 17, paramIntent, null);
          }
          setDefaultEditCommentText("");
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      paramInt1 = 0;
      continue;
      if (paramInt1 == 0)
      {
        paramIntent = new JSONObject(paramIntent).optString("comment");
        if (TextUtils.isEmpty(paramIntent)) {
          break;
        }
        setDefaultEditCommentText(new String(Base64Util.decode(paramIntent.getBytes(), 0)));
        return;
      }
      new JSONObject().put("retCode", -1);
      QQToast.a(getContext(), 1, "评论失败!", 0).a();
      return;
    }
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLong > 0L)
    {
      if (paramLong > this.jdField_a_of_type_Int) {
        localStringBuilder.append(this.jdField_a_of_type_Int + "+");
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
        this.jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        localStringBuilder.append(paramLong);
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initData. bundle data is null.");
      }
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("row_key", null);
    byte[] arrayOfByte = paramBundle.getByteArray("gallery_info");
    if (arrayOfByte != null) {}
    try
    {
      this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo = ((gallery.GalleryInfo)new gallery.GalleryInfo().mergeFrom(arrayOfByte));
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_favorite");
      this.jdField_b_of_type_Int = paramBundle.getInt("comment_count");
      this.jdField_c_of_type_Int = paramBundle.getInt("ability_mask");
      this.jdField_d_of_type_JavaLangString = paramBundle.getString("comment_list_jump_url");
      a(this.jdField_b_of_type_Int);
      b();
      if (!this.jdField_a_of_type_Boolean) {
        super.setVisibility(0);
      }
      a();
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      paramView.setOnClickListener(this);
    }
  }
  
  public int b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    int i = 4;
    if ((this.jdField_c_of_type_Int & 0x1) != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (this.jdField_b_of_type_Int > 0) {
        i = 0;
      }
      localTextView.setVisibility(i);
      if ((this.jdField_c_of_type_Int & 0x2) == 0) {
        break label93;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Int & 0x4) == 0) {
        break label105;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label93:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label105:
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.process.fav");
      getContext().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    int i;
    if (l - this.jdField_a_of_type_Long > 500L)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener == null) {
        break label132;
      }
      switch (paramView.getId())
      {
      case 2131364041: 
      default: 
        i = 2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener.a(i, paramView)) {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onClick. handledByListener.");
          }
        }
        break;
      }
    }
    label132:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            QLog.i(jdField_a_of_type_JavaLangString, 1, "quick click btn is forbidden.");
            return;
            i = 1;
            break;
            i = 2;
            break;
            i = 3;
            break;
            i = 4;
            break;
            switch (paramView.getId())
            {
            case 2131364041: 
            default: 
              return;
            }
          } while ((!(getContext() instanceof Activity)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)));
          paramView = (Activity)getContext();
          localObject = new Intent();
          ((Intent)localObject).putExtra("arg_comment_enable_anonymous", false);
          ((Intent)localObject).putExtra("arg_comment_placeholder", "我来说两句");
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            ((Intent)localObject).putExtra("arg_comment_default_txt", this.jdField_c_of_type_JavaLangString);
          }
          ((Intent)localObject).putExtra("arg_comment_max_length", 100);
          ((Intent)localObject).putExtra("arg_comment_comment_type", 1);
          ((Intent)localObject).putExtra("arg_comment_source_type", 3);
          ((Intent)localObject).putExtra("arg_comment_open_at", 0);
          ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
          PublicTransFragmentActivity.b(paramView, (Intent)localObject, ReadInJoyCommentComponentFragment.class, 6001);
          return;
        } while ((!(getContext() instanceof Activity)) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)));
        paramView = (Activity)getContext();
        localObject = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("finish_animation_out_to_right", true);
        paramView.startActivityForResult((Intent)localObject, 6003);
        paramView.overridePendingTransition(2131034363, 0);
        return;
      } while (this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_b_of_type_AndroidWidgetImageView.isSelected())
      {
        setFavorite(false);
        paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ReadInJoyAtlasManager.a().a((Activity)getContext(), paramView.getAccount(), 3, this.jdField_b_of_type_JavaLangString, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_b_of_type_JavaLangString));
        return;
      }
      setFavorite(true);
      ReadInJoyAtlasManager.a();
      ReadInJoyAtlasManager.a(getContext(), false);
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_subject.get().toStringUtf8();
      ReadInJoyAtlasManager.a();
      String str1 = ReadInJoyAtlasManager.a(this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo);
      String str2 = ReadInJoyUtils.f(this.jdField_b_of_type_JavaLangString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("picNum", (int)this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.uint64_pic_count.get());
      localBundle.putLong("publishAccountUin", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.uint64_publisher_uin.get());
      localBundle.putString("publishAccountName", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_publisher_name.get().toStringUtf8());
      ReadInJoyAtlasManager.a().a((Activity)getContext(), paramView.getAccount(), 3, this.jdField_b_of_type_JavaLangString, (String)localObject, "", str1, str2, localBundle);
      return;
    } while ((!(getContext() instanceof Activity)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)));
    paramView = (Activity)getContext();
    Object localObject = new Intent(paramView, ReadInJoyDeliverBiuActivity.class);
    ((Intent)localObject).putExtra("biu_src", 17);
    ((Intent)localObject).putExtra("biu_rowkey", this.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("arg_title", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_subject.get().toStringUtf8());
    ((Intent)localObject).putExtra("arg_src", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_publisher_name.get().toStringUtf8());
    ((Intent)localObject).putExtra("arg_type", 3);
    ((Intent)localObject).putExtra("arg_cover", this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo.bytes_summary_pic_url.get().toStringUtf8());
    paramView.startActivityForResult((Intent)localObject, 6002);
    paramView.overridePendingTransition(0, 0);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_d_of_type_Boolean)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public void setDefaultEditCommentText(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setFavorite(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_b_of_type_AndroidWidgetImageView.isSelected()) {
        this.jdField_b_of_type_AndroidWidgetImageView.setSelected(true);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.isSelected()) {
        this.jdField_b_of_type_AndroidWidgetImageView.setSelected(false);
      }
    }
  }
  
  public void setOnAllInOneEventListener(ReadInJoyAllInOneBar.OnAllInOnEventListener paramOnAllInOnEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener = paramOnAllInOnEventListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar
 * JD-Core Version:    0.7.0.1
 */