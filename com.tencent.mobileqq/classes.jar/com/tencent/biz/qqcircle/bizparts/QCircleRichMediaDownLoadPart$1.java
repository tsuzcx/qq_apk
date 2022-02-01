package com.tencent.biz.qqcircle.bizparts;

import vfg;

public class QCircleRichMediaDownLoadPart$1
  implements Runnable
{
  public QCircleRichMediaDownLoadPart$1(vfg paramvfg, String paramString, Object paramObject) {}
  
  public void run()
  {
    if ("rich_media_download_show".equals(this.jdField_a_of_type_JavaLangString)) {
      vfg.a(this.this$0);
    }
    do
    {
      do
      {
        return;
        if (!"rich_media_download_status".equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!(this.jdField_a_of_type_JavaLangObject instanceof Boolean));
      vfg.a(this.this$0, ((Boolean)this.jdField_a_of_type_JavaLangObject).booleanValue());
      return;
    } while ((!"rich_meida_download_progress".equals(this.jdField_a_of_type_JavaLangString)) || (!(this.jdField_a_of_type_JavaLangObject instanceof Integer)));
    vfg.a(this.this$0, ((Integer)this.jdField_a_of_type_JavaLangObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart.1
 * JD-Core Version:    0.7.0.1
 */