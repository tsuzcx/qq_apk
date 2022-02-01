package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import org.json.JSONObject;

public class SubscribeMultiPicSharedCardView
  extends AbsSubscribeShareCardView
{
  protected CornerImageView m;
  protected SquareImageView n;
  protected FrameLayout o;
  private TextView p;
  private AsyncRichTextView q;
  private ImageView r;
  
  public SubscribeMultiPicSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubscribeMultiPicSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubscribeMultiPicSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    this.l = paramView.findViewById(2131430453);
    this.m = ((CornerImageView)paramView.findViewById(2131430457));
    this.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.m.setBackgroundColor(-1);
    this.m.setRadius(ScreenUtil.dip2px(2.0F));
    this.n = ((SquareImageView)paramView.findViewById(2131430451));
    this.p = ((TextView)paramView.findViewById(2131430454));
    this.q = ((AsyncRichTextView)paramView.findViewById(2131430455));
    this.r = ((ImageView)paramView.findViewById(2131445806));
    this.r.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.o = ((FrameLayout)findViewById(2131430452));
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    super.a(paramShareInfoBean, paramBitmap, paramShareDataBindListener);
    CertifiedAccountMeta.StFeed localStFeed = paramShareInfoBean.a();
    String str;
    if (localStFeed != null)
    {
      this.p.setText(this.g.g());
      paramShareInfoBean = this.g.a().title.get();
      localObject = paramShareInfoBean;
      if (TextUtils.isEmpty(paramShareInfoBean)) {
        localObject = this.g.a().content.get();
      }
      paramShareInfoBean = (ShareInfoBean)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        str = this.g.a().ext.get();
        paramShareInfoBean = (ShareInfoBean)localObject;
      }
    }
    try
    {
      if (TextUtils.isEmpty(str)) {
        break label140;
      }
      paramShareInfoBean = (ShareInfoBean)localObject;
      if (!JSONUtil.isJson(str)) {
        break label140;
      }
      paramShareInfoBean = new JSONObject(str).optString("title");
    }
    catch (Exception paramShareInfoBean)
    {
      label137:
      int i;
      int j;
      break label137;
    }
    paramShareInfoBean = "";
    label140:
    Object localObject = paramShareInfoBean;
    if (TextUtils.isEmpty(paramShareInfoBean)) {
      localObject = HardCodeUtil.a(2131916932);
    }
    this.q.setText((CharSequence)localObject);
    if (paramBitmap != null) {
      this.r.setImageBitmap(paramBitmap);
    }
    if (localStFeed.images.size() > 0)
    {
      i = ((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).width.get();
      j = ((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).height.get();
      a(this.o, i, j);
      this.m.getLayoutParams().width = this.m.getWidth();
      this.m.getLayoutParams().height = this.m.getHeight();
      this.j.add(((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).url.get());
      this.k.add(this.m);
      this.j.add(localStFeed.poster.icon.get());
      this.k.add(this.n);
      a(this.j, this.k, paramShareDataBindListener);
    }
  }
  
  public int getLayoutId()
  {
    return 2131624392;
  }
  
  protected URLImageView getTopImg()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeMultiPicSharedCardView
 * JD-Core Version:    0.7.0.1
 */