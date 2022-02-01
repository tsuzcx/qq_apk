import android.os.Bundle;
import com.tencent.vas.update.callback.listener.IDownloadListener;

class bgkl
  extends bgod
{
  bgkl(bgkk parambgkk) {}
  
  public void onDone(bgoe parambgoe)
  {
    int j = 0;
    if ((bgkk.a(this.a) == null) || (parambgoe == null)) {
      return;
    }
    Object localObject;
    String str;
    if ((parambgoe.a() == 3) && (parambgoe.jdField_a_of_type_Int == 0))
    {
      i = 1;
      localObject = parambgoe.a();
      if ((localObject != null) && (((Bundle)localObject).getString("from") != null) && (((Bundle)localObject).getString("from").contains("silent_download"))) {
        bgkk.a(this.a, parambgoe.c, parambgoe.jdField_a_of_type_Long);
      }
      localObject = bgkk.a(this.a);
      str = parambgoe.jdField_a_of_type_JavaLangString;
      if (i == 0) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 8)
    {
      ((IDownloadListener)localObject).onCompleted(str, i, parambgoe.jdField_a_of_type_Int, parambgoe.jdField_b_of_type_JavaLangString);
      return;
      i = 0;
      break;
    }
  }
  
  public void onProgress(bgoe parambgoe)
  {
    if ((bgkk.a(this.a) != null) && (parambgoe != null)) {
      bgkk.a(this.a).onProgress(parambgoe.jdField_a_of_type_JavaLangString, parambgoe.jdField_b_of_type_Long, parambgoe.jdField_a_of_type_Long, (int)parambgoe.jdField_a_of_type_Float);
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    if (parambgoe == null) {
      return false;
    }
    if (bgkk.a(this.a) != null) {
      bgkk.a(this.a).onDownloadStart(parambgoe.jdField_a_of_type_JavaLangString);
    }
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkl
 * JD-Core Version:    0.7.0.1
 */