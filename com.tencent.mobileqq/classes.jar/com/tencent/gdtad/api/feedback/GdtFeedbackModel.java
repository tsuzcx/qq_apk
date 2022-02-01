package com.tencent.gdtad.api.feedback;

import android.graphics.drawable.Drawable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import java.util.ArrayList;
import java.util.Iterator;

final class GdtFeedbackModel
{
  private static final String jdField_a_of_type_JavaLangString = "GdtFeedbackModel";
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  protected ArrayList<GdtFeedbackModel.GdtFeedbackItemModel> a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public GdtFeedbackModel()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      GdtFeedbackModel.GdtFeedbackItemModel localGdtFeedbackItemModel = (GdtFeedbackModel.GdtFeedbackItemModel)localIterator.next();
      GdtFeedbackModel.GdtFeedbackItemModel.b(localGdtFeedbackItemModel);
      GdtFeedbackModel.GdtFeedbackItemModel.c(localGdtFeedbackItemModel);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public Drawable a(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public AdError a()
  {
    AdLog.i(jdField_a_of_type_JavaLangString, "[loadData] start loading");
    if (!this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.isValid())
    {
      AdLog.i(jdField_a_of_type_JavaLangString, "[loadData] mAd is invalid");
      return new AdError(4);
    }
    int j = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getFeedbackItemNum();
    if (j <= 0) {
      return new AdError(4);
    }
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        GdtFeedbackModel.GdtFeedbackItemModel localGdtFeedbackItemModel = new GdtFeedbackModel.GdtFeedbackItemModel();
        GdtFeedbackModel.GdtFeedbackItemModel.a(localGdtFeedbackItemModel, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getIconUrlForFeedbackItem(i));
        GdtFeedbackModel.GdtFeedbackItemModel.a(localGdtFeedbackItemModel, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getReportTypeForFeedbackItem(i));
        GdtFeedbackModel.GdtFeedbackItemModel.b(localGdtFeedbackItemModel, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getActionTypeForFeedbackItem(i));
        GdtFeedbackModel.GdtFeedbackItemModel.b(localGdtFeedbackItemModel, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getTextForFeedbackItem(i));
        GdtFeedbackModel.GdtFeedbackItemModel.c(localGdtFeedbackItemModel, "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/web%E5%BC%80%E5%8F%91%E7%BB%84/%E8%B5%84%E6%BA%90%E6%96%87%E4%BB%B6/%E7%AE%AD%E5%A4%B4-%E6%A8%AA%E7%89%88@2x.png");
        GdtFeedbackModel.GdtFeedbackItemModel.d(localGdtFeedbackItemModel, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getJumpUrlForFeedbackItem(i));
        GdtFeedbackModel.GdtFeedbackItemModel.e(localGdtFeedbackItemModel, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForFeedBack());
        this.jdField_a_of_type_JavaUtilArrayList.add(localGdtFeedbackItemModel);
        i += 1;
      }
      catch (Exception localException)
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[loadData] fail to load data: ");
        localStringBuilder.append(localException.getMessage());
        AdLog.e(str, localStringBuilder.toString());
      }
    }
    a();
    AdLog.i(jdField_a_of_type_JavaLangString, "[loadData] finish loading successfully");
    return new AdError(0);
    return new AdError(4);
  }
  
  public String a(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void a(int paramInt)
  {
    GdtFeedbackModel.GdtFeedbackItemModel.a((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void a(GdtAd paramGdtAd)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public Drawable b(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.b((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public String b(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.b((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c(int paramInt)
  {
    return GdtFeedbackModel.GdtFeedbackItemModel.c((GdtFeedbackModel.GdtFeedbackItemModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackModel
 * JD-Core Version:    0.7.0.1
 */