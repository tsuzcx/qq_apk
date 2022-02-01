package com.tencent.biz.qqstory.newshare.job;

import android.text.TextUtils;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.Map;

public class UrlDrawableDownloadJob
  extends Job
{
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  
  public UrlDrawableDownloadJob()
  {
    a(false, true);
  }
  
  public UrlDrawableDownloadJob(String paramString)
  {
    this();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new UrlDrawableDownloadJob.1(this));
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() != null))
    {
      a("UrlDrawableDownloadJob_dra", this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
      b(true);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UrlDrawableDownloadJob_iiu"))) {
      this.jdField_a_of_type_JavaLangString = ((String)ShareUtils.a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap, "UrlDrawableDownloadJob_iiu", this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.UrlDrawableDownloadJob
 * JD-Core Version:    0.7.0.1
 */