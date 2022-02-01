package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aaap;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;
import zqh;
import zqn;
import zsf;

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
    return 2131558835;
  }
  
  protected URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377586);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131377581));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377588));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377582));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377589));
    this.d = ((TextView)paramView.findViewById(2131377584));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377579));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377580));
  }
  
  public void a(zsf paramzsf, Bitmap paramBitmap, aaap paramaaap)
  {
    super.a(paramzsf, paramBitmap, paramaaap);
    CertifiedAccountMeta.StUser localStUser;
    if ((paramzsf != null) && (paramzsf.a() != null) && (paramzsf.a().poster != null))
    {
      localStUser = paramzsf.a().poster;
      if (!TextUtils.isEmpty(localStUser.iconInfo.iconUrl.get())) {
        break label251;
      }
    }
    label251:
    for (paramzsf = localStUser.icon.get();; paramzsf = localStUser.iconInfo.iconUrl.get())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1.add(paramzsf);
      localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      a(localArrayList1, localArrayList2, paramaaap);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStUser.nick.get());
      paramaaap = localStUser.desc.get();
      if ((!TextUtils.isEmpty(paramaaap)) && (!paramaaap.equals(anvx.a(2131719098))))
      {
        paramzsf = paramaaap;
        if (!TextUtils.isEmpty(paramaaap.trim())) {}
      }
      else
      {
        paramzsf = anvx.a(2131719097);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramzsf);
      paramzsf = zqh.a();
      if (paramzsf != null)
      {
        this.d.setText(zqn.a(paramzsf.fansCount.get()));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(zqn.a(paramzsf.feedCount.get()));
        measure(jdField_c_of_type_Int, e);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubScribePersonalSharedCardView
 * JD-Core Version:    0.7.0.1
 */