import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;

class bdvn
  implements bdvw
{
  bdvn(bdvl parambdvl, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void onResp(bdwt parambdwt) {}
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    int i;
    if ((paramLong1 > 0L) && (paramLong2 > 0L)) {
      i = (int)((float)paramLong1 / (float)paramLong2 * 9500.0F);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(i);
      }
      return;
    }
    catch (Throwable parambdws)
    {
      QLog.e("HttpDownloader", 1, "onUpdateProgeress error.", parambdws);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvn
 * JD-Core Version:    0.7.0.1
 */