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
  public ImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public QzoneImagesContainer f;
  private AccountSearchPb.ResultItem g;
  
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
  
  public void a(BaseActivity paramBaseActivity)
  {
    QZoneHelper.forwardToDetail(paramBaseActivity, QZoneHelper.UserInfo.getInstance(), this.g.jmp_url.get().toStringUtf8(), -1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SearchBaseFragment paramSearchBaseFragment, AccountSearchPb.ResultItem paramResultItem)
  {
    if ((paramResultItem != null) && (paramSearchBaseFragment != null) && (paramQQAppInterface != null))
    {
      setVisibility(0);
      this.g = paramResultItem;
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(getUin());
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
        this.b.setText((CharSequence)localObject2);
      }
      else if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = paramSearchBaseFragment.a(80000004, paramQQAppInterface);
        this.b.setText(paramQQAppInterface);
      }
      else
      {
        this.b.setText(getUin());
      }
      if (l > 0L) {
        this.c.setText(localCharSequence);
      } else {
        this.c.setVisibility(8);
      }
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, (String)localObject1);
      if (TextUtils.isEmpty(paramQQAppInterface))
      {
        this.d.setVisibility(8);
        this.e.setMaxLines(2);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
      }
      else
      {
        this.d.setVisibility(0);
        localObject1 = new SpannableStringBuilder("《");
        ((SpannableStringBuilder)localObject1).append(paramQQAppInterface).append("》");
        this.d.setText((CharSequence)localObject1);
        this.e.setMaxLines(1);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
      }
      paramQQAppInterface = paramSearchBaseFragment.a(80000004, str);
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        this.e.setVisibility(8);
      } else {
        this.e.setText(paramQQAppInterface);
      }
      boolean bool = "1".equals(paramResultItem.has_video.get().toStringUtf8());
      this.f.setImages(localList, i, bool);
      return;
    }
    setVisibility(8);
  }
  
  public String getUin()
  {
    return String.valueOf(this.g.uin.get());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(2131434916));
    this.b = ((TextView)findViewById(2131433208));
    this.c = ((TextView)findViewById(2131440870));
    this.d = ((TextView)findViewById(2131447463));
    this.e = ((TextView)findViewById(2131446627));
    this.f = ((QzoneImagesContainer)findViewById(2131435434));
  }
  
  public void setAvartaView(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.setVisibility(0);
      this.a.setImageBitmap(paramBitmap);
      return;
    }
    this.a.setVisibility(0);
    this.a.setImageBitmap(ImageUtil.k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.QzoneSearchResultView
 * JD-Core Version:    0.7.0.1
 */