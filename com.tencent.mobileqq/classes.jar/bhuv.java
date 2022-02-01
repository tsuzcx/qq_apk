import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;

class bhuv
  extends bhyn
{
  bhuv(bhuu parambhuu) {}
  
  public void onDone(bhyo parambhyo)
  {
    int j = 0;
    if ((bhuu.a(this.a) == null) || (parambhyo == null)) {
      return;
    }
    Object localObject;
    String str;
    if ((parambhyo.a() == 3) && (parambhyo.jdField_a_of_type_Int == 0))
    {
      i = 1;
      localObject = parambhyo.a();
      if ((localObject != null) && (((Bundle)localObject).getString("from") != null) && (((Bundle)localObject).getString("from").contains("silent_download"))) {
        bhuu.a(this.a, parambhyo.c, parambhyo.jdField_a_of_type_Long);
      }
      localObject = bhuu.a(this.a);
      str = parambhyo.jdField_a_of_type_JavaLangString;
      if (i == 0) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 8)
    {
      ((IDownloadListener)localObject).onCompleted(str, i, parambhyo.jdField_a_of_type_Int, parambhyo.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  public void onProgress(bhyo parambhyo)
  {
    if ((bhuu.a(this.a) != null) && (parambhyo != null)) {
      bhuu.a(this.a).onProgress(parambhyo.jdField_a_of_type_JavaLangString, parambhyo.jdField_b_of_type_Long, parambhyo.jdField_a_of_type_Long, (int)parambhyo.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    if (parambhyo == null) {
      return false;
    }
    if (bhuu.a(this.a) != null) {
      bhuu.a(this.a).onDownloadStart(parambhyo.jdField_a_of_type_JavaLangString);
    }
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuv
 * JD-Core Version:    0.7.0.1
 */