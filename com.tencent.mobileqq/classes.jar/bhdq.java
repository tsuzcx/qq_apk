import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;

class bhdq
  extends bhhe
{
  bhdq(bhdp parambhdp) {}
  
  public void onDone(bhhf parambhhf)
  {
    int j = 0;
    if ((bhdp.a(this.a) == null) || (parambhhf == null)) {
      return;
    }
    Object localObject;
    String str;
    if ((parambhhf.a() == 3) && (parambhhf.jdField_a_of_type_Int == 0))
    {
      i = 1;
      localObject = parambhhf.a();
      if ((localObject != null) && (((Bundle)localObject).getString("from") != null) && (((Bundle)localObject).getString("from").contains("silent_download"))) {
        bhdp.a(this.a, parambhhf.c, parambhhf.jdField_a_of_type_Long);
      }
      localObject = bhdp.a(this.a);
      str = parambhhf.jdField_a_of_type_JavaLangString;
      if (i == 0) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 8)
    {
      ((IDownloadListener)localObject).onCompleted(str, i, parambhhf.jdField_a_of_type_Int, parambhhf.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  public void onProgress(bhhf parambhhf)
  {
    if ((bhdp.a(this.a) != null) && (parambhhf != null)) {
      bhdp.a(this.a).onProgress(parambhhf.jdField_a_of_type_JavaLangString, parambhhf.jdField_b_of_type_Long, parambhhf.jdField_a_of_type_Long, (int)parambhhf.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    if ((bhdp.a(this.a) != null) && (parambhhf != null)) {
      bhdp.a(this.a).onDownloadStart(parambhhf.jdField_a_of_type_JavaLangString);
    }
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdq
 * JD-Core Version:    0.7.0.1
 */