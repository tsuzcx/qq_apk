package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aaee;
import aaek;
import aagc;
import aaop;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;

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
    return 2131558802;
  }
  
  protected URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  }
  
  public void a(aagc paramaagc, Bitmap paramBitmap, aaop paramaaop)
  {
    super.a(paramaagc, paramBitmap, paramaaop);
    CertifiedAccountMeta.StUser localStUser;
    if ((paramaagc != null) && (paramaagc.a() != null) && (paramaagc.a().poster != null))
    {
      localStUser = paramaagc.a().poster;
      if (!TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        break label251;
      }
    }
    label251:
    for (paramaagc = localStUser.icon.get();; paramaagc = localStUser.iconInfo.iconUrl.get())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramaagc);
      localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      a(localArrayList1, localArrayList2, paramaaop);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
      paramaaop = localStUser.desc.get();
      if ((!TextUtils.isEmpty(paramaaop)) && (!paramaaop.equals(anzj.a(2131718461))))
      {
        paramaagc = paramaaop;
        if (!TextUtils.isEmpty(paramaaop.trim())) {}
      }
      else
      {
        paramaagc = anzj.a(2131718460);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramaagc);
      paramaagc = aaee.a();
      if (paramaagc != null)
      {
        this.d.setText(aaek.a(paramaagc.fansCount.get()));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(aaek.a(paramaagc.feedCount.get()));
        measure(jdField_c_of_type_Int, e);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377545);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131377540));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377547));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377541));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377548));
    this.d = ((TextView)paramView.findViewById(2131377543));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377538));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377539));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */