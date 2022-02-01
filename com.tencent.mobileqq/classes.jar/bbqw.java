import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class bbqw
{
  public int a;
  public long a;
  public MessageForShortVideo a;
  String jdField_a_of_type_JavaLangString;
  public String[] a;
  
  public bbqw(bbqt parambbqt, String[] paramArrayOfString, long paramLong, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    BrowserLogHelper.getInstance().getGalleryLog().d(" LongVideoUrlCacheManager", 4, "UrlsCacheBean, now=  " + l1 + ", mGetTime" + this.jdField_a_of_type_Long + " diff=" + l2 + " urlTimeValidDiff=" + bbqt.a());
    return l2 < bbqt.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqw
 * JD-Core Version:    0.7.0.1
 */