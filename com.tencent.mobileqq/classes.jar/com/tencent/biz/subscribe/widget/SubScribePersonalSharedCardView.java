package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import ajya;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import win;
import wit;
import wkm;
import wun;

public class SubScribePersonalSharedCardView
  extends AbsSubscribeShareCardView
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public SubScribePersonalSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubScribePersonalSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    return 2131558703;
  }
  
  protected URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376048);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131376043));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376050));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376044));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376051));
    this.d = ((TextView)paramView.findViewById(2131376046));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376041));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376042));
  }
  
  public void a(wkm paramwkm, Bitmap paramBitmap, wun paramwun)
  {
    super.a(paramwkm, paramBitmap, paramwun);
    CertifiedAccountMeta.StUser localStUser;
    if ((paramwkm != null) && (paramwkm.a() != null) && (paramwkm.a().poster != null))
    {
      localStUser = paramwkm.a().poster;
      if (!TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        break label251;
      }
    }
    label251:
    for (paramwkm = localStUser.icon.get();; paramwkm = localStUser.iconInfo.iconUrl.get())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramwkm);
      localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      a(localArrayList1, localArrayList2, paramwun);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
      paramwun = localStUser.desc.get();
      if ((!TextUtils.isEmpty(paramwun)) && (!paramwun.equals(ajya.a(2131719933))))
      {
        paramwkm = paramwun;
        if (!TextUtils.isEmpty(paramwun.trim())) {}
      }
      else
      {
        paramwkm = ajya.a(2131719932);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramwkm);
      paramwkm = win.a();
      if (paramwkm != null)
      {
        this.d.setText(wit.a(paramwkm.fansCount.get()));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(wit.a(paramwkm.feedCount.get()));
        measure(jdField_c_of_type_Int, e);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */