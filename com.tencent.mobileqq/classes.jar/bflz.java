import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.open.base.ToastUtil.1;
import com.tencent.open.base.ToastUtil.2;
import com.tencent.open.base.ToastUtil.3;

public class bflz
{
  protected static bflz a;
  protected Handler a;
  public Toast a;
  public Toast b;
  
  public bflz()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static bflz a()
  {
    if (jdField_a_of_type_Bflz == null) {
      jdField_a_of_type_Bflz = new bflz();
    }
    return jdField_a_of_type_Bflz;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ToastUtil.2(this, paramInt1, paramInt2));
  }
  
  public void a(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ToastUtil.3(this, paramView, paramInt));
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ToastUtil.1(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bflz
 * JD-Core Version:    0.7.0.1
 */