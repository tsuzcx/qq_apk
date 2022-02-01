import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;

class biea
  extends biht
{
  biea(bidz parambidz) {}
  
  public void onDone(bihu parambihu)
  {
    int j = 0;
    if ((bidz.a(this.a) == null) || (parambihu == null)) {
      return;
    }
    Object localObject;
    String str;
    if ((parambihu.a() == 3) && (parambihu.jdField_a_of_type_Int == 0))
    {
      i = 1;
      localObject = parambihu.a();
      if ((localObject != null) && (((Bundle)localObject).getString("from") != null) && (((Bundle)localObject).getString("from").contains("silent_download"))) {
        bidz.a(this.a, parambihu.c, parambihu.jdField_a_of_type_Long);
      }
      localObject = bidz.a(this.a);
      str = parambihu.jdField_a_of_type_JavaLangString;
      if (i == 0) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 8)
    {
      ((IDownloadListener)localObject).onCompleted(str, i, parambihu.jdField_a_of_type_Int, parambihu.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  public void onProgress(bihu parambihu)
  {
    if ((bidz.a(this.a) != null) && (parambihu != null)) {
      bidz.a(this.a).onProgress(parambihu.jdField_a_of_type_JavaLangString, parambihu.jdField_b_of_type_Long, parambihu.jdField_a_of_type_Long, (int)parambihu.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(bihu parambihu)
  {
    if ((bidz.a(this.a) != null) && (parambihu != null)) {
      bidz.a(this.a).onDownloadStart(parambihu.jdField_a_of_type_JavaLangString);
    }
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biea
 * JD-Core Version:    0.7.0.1
 */