package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bgxc;
import bmhv;
import bmhz;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import pic;
import pjr;
import ppe;
import pqw;
import qfw;
import rbx;
import rfw;
import rps;
import rpt;
import rrq;
import rrs;
import six;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  Pair<Integer, Integer> jdField_a_of_type_AndroidUtilPair;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView d;
  TextView e;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    int i = DisplayUtil.dip2px(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  @SuppressLint({"Range"})
  private void c()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Rfw.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsText))
    {
      String str;
      if (TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsColor)) {
        str = "#FE6c6c";
      }
      try
      {
        for (;;)
        {
          this.e.setTextColor(Color.parseColor("#ffffff"));
          pic.a(this.e, a(Color.parseColor(str), getContext()));
          this.e.setText(localArticleInfo.mVideoArticleSubsText);
          this.e.setVisibility(0);
          return;
          str = localArticleInfo.mVideoArticleSubsColor;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 2, "configDefaultItem: ", localException);
          }
          this.e.setTextColor(Color.parseColor("#ffffff"));
          pic.a(this.e, a(Color.parseColor("#FE6c6c"), getContext()));
        }
      }
    }
    this.e.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560173, this, true);
  }
  
  public URL a(qfw paramqfw)
  {
    URL localURL = null;
    Object localObject = paramqfw.a();
    if (ComponentPolymericView.a(paramqfw))
    {
      paramqfw = ((rpt)((ArticleInfo)localObject).mNewPolymericInfo.a.get(0)).c;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl new polymeric video cover rawUrl = " + paramqfw);
      }
      localURL = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramqfw);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("getUrl new polymeric video cover after smartcut url = ");
        if (localURL != null)
        {
          paramqfw = localURL.getFile();
          QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramqfw);
        }
      }
      else
      {
        paramqfw = localURL;
      }
    }
    do
    {
      return paramqfw;
      paramqfw = null;
      break;
      paramqfw = ((ArticleInfo)localObject).getVideoCoverURL();
      if (paramqfw == null) {
        break label277;
      }
      paramqfw = paramqfw.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl old polymeric video cover rawUrl = " + paramqfw);
      }
      localObject = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramqfw);
      paramqfw = (qfw)localObject;
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("getUrl old polymeric video cover after smartcut url = ");
    paramqfw = localURL;
    if (localObject != null) {
      paramqfw = ((URL)localObject).getFile();
    }
    QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramqfw);
    return localObject;
    label277:
    return ((ArticleInfo)localObject).getVideoCoverURL();
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368573));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368572));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364347));
    this.d = ((TextView)paramView.findViewById(2131364924));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380981));
    this.e = ((TextView)paramView.findViewById(2131378288));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368574);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376967));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372928));
  }
  
  public void a(Object paramObject)
  {
    qfw localqfw;
    if ((paramObject instanceof qfw))
    {
      localqfw = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(localqfw);
      if (localqfw.f() != 1) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramObject = localqfw.a();
      if (paramObject != null) {
        break;
      }
      return;
    }
    if (pqw.g(paramObject))
    {
      this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(AIOUtils.dp2px(165.0F, getResources())), Integer.valueOf(AIOUtils.dp2px(293.0F, getResources())));
      findViewById(2131365531).setVisibility(8);
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_Rfw.a.e() == 56)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(getResources().getDrawable(2130843234));
        label148:
        if (!this.jdField_a_of_type_Boolean) {
          break label411;
        }
        Object localObject = pjr.a(1, this.jdField_a_of_type_Rfw.a.e());
        localObject = URLDrawable.getDrawable(a(localqfw), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject).setDecodeHandler(bgxc.u);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(new ColorDrawable(-1447447));
      }
      try
      {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(a(localqfw));
        if (pqw.g(paramObject))
        {
          this.d.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          c();
          return;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidUtilPair = pjr.a(3, this.jdField_a_of_type_Rfw.a.e());
            continue;
          }
          this.jdField_a_of_type_AndroidUtilPair = pjr.a(this.jdField_a_of_type_Rfw.a.f(), this.jdField_a_of_type_Rfw.a.e());
          continue;
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
          break label148;
          label411:
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "bindData setVideoCover failed. Exception e = " + localException);
          continue;
          bmhz localbmhz = bmhv.a(BaseApplicationImpl.getApplication().getRuntime());
          if ((localbmhz != null) && (localbmhz.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, getResources()));
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130849356, 0, 0, 0);
            label521:
            if ((localbmhz == null) || (localbmhz.b)) {
              break label585;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          for (;;)
          {
            if ((localbmhz == null) || (localbmhz.c)) {
              break label658;
            }
            this.d.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            break;
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label521;
            label585:
            if ((localbmhz != null) && (localbmhz.jdField_a_of_type_Int > 0)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(localbmhz.jdField_a_of_type_Int);
            }
            if (ppe.q(paramObject)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mTitle);
            } else {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(((rrs)paramObject.mSocialFeedInfo.a.b.get(0)).e);
            }
          }
          label658:
          this.d.setText(getResources().getString(2131717643, new Object[] { paramObject.getCommentCount() + "" }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(six.c(paramObject.mVideoPlayCount));
          }
        }
      }
    }
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue();
    localLayoutParams.height = ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */