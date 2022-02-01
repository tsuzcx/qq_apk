package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.ResultItem;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.widget.QzoneImagesContainer;
import java.util.List;

public class QzoneSearchResultView
  extends LinearLayout
{
  private AccountSearchPb.ResultItem a;
  public ImageView a;
  public TextView a;
  public QzoneImagesContainer a;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public QzoneSearchResultView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneSearchResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString)
  {
    QZoneHelper.forwardToBrowser(paramBaseActivity, paramString, -1, null, null);
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_AddcontactsAccountSearchPb$ResultItem.uin.get());
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    QZoneHelper.forwardToDetail(paramBaseActivity, QZoneHelper.UserInfo.getInstance(), this.jdField_a_of_type_AddcontactsAccountSearchPb$ResultItem.jmp_url.get().toStringUtf8(), -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SearchBaseFragment paramSearchBaseFragment, AccountSearchPb.ResultItem paramResultItem)
  {
    if ((paramResultItem != null) && (paramSearchBaseFragment != null) && (paramQQAppInterface != null))
    {
      setVisibility(0);
      this.jdField_a_of_type_AddcontactsAccountSearchPb$ResultItem = paramResultItem;
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(a());
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramQQAppInterface.name;
      } else {
        paramQQAppInterface = "";
      }
      Object localObject2 = paramResultItem.nick_name.get().toStringUtf8();
      Object localObject1 = paramResultItem.name.get().toStringUtf8();
      String str = paramResultItem.summary.get().toStringUtf8();
      List localList = paramResultItem.pic_url_list.get();
      int i = paramResultItem.total_pic_num.get();
      long l = paramResultItem.ftime.get();
      CharSequence localCharSequence = TimeFormatterUtils.a(getContext(), 3, l * 1000L, false);
      localObject2 = paramSearchBaseFragment.a(80000004, (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      }
      else if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramSearchBaseFragment.a(80000004, paramQQAppInterface);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQAppInterface);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
      }
      if (l > 0L) {
        this.b.setText(localCharSequence);
      } else {
        this.b.setVisibility(8);
      }
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, (String)localObject1);
      if (TextUtils.isEmpty(paramQQAppInterface))
      {
        this.c.setVisibility(8);
        this.d.setMaxLines(2);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
      }
      else
      {
        this.c.setVisibility(0);
        localObject1 = new SpannableStringBuilder("《");
        ((SpannableStringBuilder)localObject1).append(paramQQAppInterface).append("》");
        this.c.setText((CharSequence)localObject1);
        this.d.setMaxLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
      }
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, str);
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        this.d.setVisibility(8);
      } else {
        this.d.setText(paramQQAppInterface);
      }
      boolean bool = "1".equals(paramResultItem.has_video.get().toStringUtf8());
      this.jdField_a_of_type_CooperationQzoneWidgetQzoneImagesContainer.setImages(localList, i, bool);
      return;
    }
    setVisibility(8);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368066));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366879));
    this.b = ((TextView)findViewById(2131373261));
    this.c = ((TextView)findViewById(2131378784));
    this.d = ((TextView)findViewById(2131378120));
    this.jdField_a_of_type_CooperationQzoneWidgetQzoneImagesContainer = ((QzoneImagesContainer)findViewById(2131368530));
  }
  
  public void setAvartaView(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ImageUtil.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.QzoneSearchResultView
 * JD-Core Version:    0.7.0.1
 */