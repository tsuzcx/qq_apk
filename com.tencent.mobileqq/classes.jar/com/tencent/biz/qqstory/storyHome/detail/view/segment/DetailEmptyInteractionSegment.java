package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;

public class DetailEmptyInteractionSegment
  extends SegmentView
{
  public static final String KEY = "DetailEmptyInteractionSegment";
  private int a;
  
  public DetailEmptyInteractionSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public void P_()
  {
    SegmentView localSegmentView1 = a().a("DetailCommentSegment");
    SegmentView localSegmentView2 = a().a("DetailLikeListSegment");
    DetailDoubleTabSegment localDetailDoubleTabSegment = (DetailDoubleTabSegment)a().a("DetailDoubleTabSegment");
    if ((localDetailDoubleTabSegment != null) && (localDetailDoubleTabSegment.a() > 0) && (localSegmentView1 != null) && (localSegmentView1.a() == 0) && (localSegmentView2 != null) && (localSegmentView2.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = localDetailDoubleTabSegment.b();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.d(this.jdField_a_of_type_AndroidContentContext);
    int i = UIUtils.e(this.jdField_a_of_type_AndroidContentContext);
    int j = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int k = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 56.0F);
    paramViewGroup = (GeneralFeedProfileSegment)a().a("GeneralFeedProfileSegment");
    ShareGroupFeedProfileSegment localShareGroupFeedProfileSegment = (ShareGroupFeedProfileSegment)a().a("ShareGroupFeedProfileSegment");
    BannerProfileSegment localBannerProfileSegment = (BannerProfileSegment)a().a("BannerProfileSegment");
    DetailInteractSegment localDetailInteractSegment = (DetailInteractSegment)a().a("DetailInteractSegment");
    DetailDoubleTabSegment localDetailDoubleTabSegment = (DetailDoubleTabSegment)a().a("DetailDoubleTabSegment");
    paramInt = paramInt - i - j - (paramViewGroup.b() + localShareGroupFeedProfileSegment.b() + localBannerProfileSegment.b() + localDetailInteractSegment.b() + localDetailDoubleTabSegment.c()) - k;
    if (paramInt > UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F)) {
      paramBaseViewHolder.a().getLayoutParams().height = paramInt;
    } else {
      paramBaseViewHolder.a().getLayoutParams().height = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    }
    SLog.b("Q.qqstory.detail.DetailEmptyInteractionSegment", "view height is %d.", Integer.valueOf(paramBaseViewHolder.a().getLayoutParams().height));
    paramViewGroup = (TextView)paramBaseViewHolder.a(2131377918);
    if (this.jdField_a_of_type_Int == 1) {
      paramViewGroup.setText(HardCodeUtil.a(2131703299));
    } else {
      paramViewGroup.setText(HardCodeUtil.a(2131703300));
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561641, paramViewGroup, false));
  }
  
  public String a()
  {
    return "DetailEmptyInteractionSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailEmptyInteractionSegment
 * JD-Core Version:    0.7.0.1
 */