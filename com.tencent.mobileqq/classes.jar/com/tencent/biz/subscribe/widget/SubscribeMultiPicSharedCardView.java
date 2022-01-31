package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import ajya;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import axlk;
import belj;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import org.json.JSONObject;
import wkm;
import wun;

public class SubscribeMultiPicSharedCardView
  extends AbsSubscribeShareCardView
{
  protected FrameLayout a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  protected CornerImageView a;
  protected SquareImageView a;
  
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
  
  public int a()
  {
    return 2131558702;
  }
  
  protected URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364015);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131364019));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(axlk.a(2.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131364013));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364016));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)paramView.findViewById(2131364017));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376038));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131364014));
  }
  
  public void a(wkm paramwkm, Bitmap paramBitmap, wun paramwun)
  {
    super.a(paramwkm, paramBitmap, paramwun);
    CertifiedAccountMeta.StFeed localStFeed = paramwkm.a();
    String str;
    if (localStFeed != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Wkm.f());
      paramwkm = this.jdField_a_of_type_Wkm.a().title.get();
      localObject = paramwkm;
      if (TextUtils.isEmpty(paramwkm)) {
        localObject = this.jdField_a_of_type_Wkm.a().content.get();
      }
      paramwkm = (wkm)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        str = this.jdField_a_of_type_Wkm.a().ext.get();
        paramwkm = (wkm)localObject;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        paramwkm = (wkm)localObject;
        if (belj.a(str)) {
          paramwkm = new JSONObject(str).optString("title");
        }
      }
    }
    catch (Exception paramwkm)
    {
      for (;;)
      {
        int i;
        int j;
        paramwkm = "";
      }
    }
    Object localObject = paramwkm;
    if (TextUtils.isEmpty(paramwkm)) {
      localObject = ajya.a(2131719953);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText((CharSequence)localObject);
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    if (localStFeed.images.size() > 0)
    {
      i = ((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).width.get();
      j = ((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).height.get();
      a(this.jdField_a_of_type_AndroidWidgetFrameLayout, i, j);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getLayoutParams().width = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getWidth();
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getHeight();
      this.jdField_a_of_type_JavaUtilArrayList.add(((CertifiedAccountMeta.StImage)localStFeed.images.get(0)).url.get());
      this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView);
      this.jdField_a_of_type_JavaUtilArrayList.add(localStFeed.poster.icon.get());
      this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList, paramwun);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeMultiPicSharedCardView
 * JD-Core Version:    0.7.0.1
 */