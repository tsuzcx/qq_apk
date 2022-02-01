package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
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
import bhez;
import bhgr;
import bnrf;
import bnrj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import oxr;
import ozc;
import ozs;
import ppu;
import qjp;
import qno;
import qwo;
import qwp;
import qyl;
import qyn;
import rpt;
import sel;

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
    int i = bhgr.a(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  @SuppressLint({"Range"})
  private void c()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qno.a.a();
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
          oxr.a(this.e, a(Color.parseColor(str), getContext()));
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
          oxr.a(this.e, a(Color.parseColor("#FE6c6c"), getContext()));
        }
      }
    }
    this.e.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560119, this, true);
  }
  
  public URL a(ppu paramppu)
  {
    URL localURL = null;
    Object localObject = paramppu.a();
    if (ComponentPolymericView.a(paramppu))
    {
      paramppu = ((qwp)((ArticleInfo)localObject).mNewPolymericInfo.a.get(0)).c;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl new polymeric video cover rawUrl = " + paramppu);
      }
      localURL = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramppu);
      if (QLog.isColorLevel())
      {
        if ("getUrl new polymeric video cover after smartcut url = " + localURL != null)
        {
          paramppu = localURL.getFile();
          QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramppu);
        }
      }
      else {
        paramppu = localURL;
      }
    }
    do
    {
      return paramppu;
      paramppu = null;
      break;
      paramppu = ((ArticleInfo)localObject).getVideoCoverURL();
      if (paramppu == null) {
        break label271;
      }
      paramppu = paramppu.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl old polymeric video cover rawUrl = " + paramppu);
      }
      localObject = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), paramppu);
      paramppu = (ppu)localObject;
    } while (!QLog.isColorLevel());
    paramppu = localURL;
    if ("getUrl old polymeric video cover after smartcut url = " + localObject != null) {
      paramppu = ((URL)localObject).getFile();
    }
    QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramppu);
    return localObject;
    label271:
    return ((ArticleInfo)localObject).getVideoCoverURL();
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368392));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368391));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364250));
    this.d = ((TextView)paramView.findViewById(2131364807));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380907));
    this.e = ((TextView)paramView.findViewById(2131378230));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368393);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376944));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372767));
  }
  
  public void a(Object paramObject)
  {
    ppu localppu;
    if ((paramObject instanceof ppu))
    {
      localppu = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(localppu);
      if (localppu.g() != 1) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramObject = localppu.a();
      if (paramObject != null) {
        break;
      }
      return;
    }
    if (ozs.s(paramObject))
    {
      this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(agej.a(165.0F, getResources())), Integer.valueOf(agej.a(293.0F, getResources())));
      findViewById(2131365406).setVisibility(8);
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_Qno.a.e() == 56)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(getResources().getDrawable(2130843136));
        label148:
        if (!this.jdField_a_of_type_Boolean) {
          break label411;
        }
        Object localObject = ozc.a(1, this.jdField_a_of_type_Qno.a.e());
        localObject = URLDrawable.getDrawable(a(localppu), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject).setDecodeHandler(bhez.u);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImagePlaceHolder(new ColorDrawable(-1447447));
      }
      try
      {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(a(localppu));
        if (ozs.s(paramObject))
        {
          this.d.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          c();
          return;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidUtilPair = ozc.a(3, this.jdField_a_of_type_Qno.a.e());
            continue;
          }
          this.jdField_a_of_type_AndroidUtilPair = ozc.a(this.jdField_a_of_type_Qno.a.g(), this.jdField_a_of_type_Qno.a.e());
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
          bnrj localbnrj = bnrf.a(BaseApplicationImpl.getApplication().getRuntime());
          if ((localbnrj != null) && (localbnrj.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(agej.a(3.0F, getResources()));
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130849353, 0, 0, 0);
            label521:
            if ((localbnrj == null) || (localbnrj.b)) {
              break label585;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          for (;;)
          {
            if ((localbnrj == null) || (localbnrj.c)) {
              break label658;
            }
            this.d.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            break;
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label521;
            label585:
            if ((localbnrj != null) && (localbnrj.jdField_a_of_type_Int > 0)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(localbnrj.jdField_a_of_type_Int);
            }
            if (sel.q(paramObject)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mTitle);
            } else {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(((qyn)paramObject.mSocialFeedInfo.a.b.get(0)).e);
            }
          }
          label658:
          this.d.setText(getResources().getString(2131717044, new Object[] { paramObject.getCommentCount() + "" }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(rpt.c(paramObject.mVideoPlayCount));
          }
        }
      }
    }
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
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