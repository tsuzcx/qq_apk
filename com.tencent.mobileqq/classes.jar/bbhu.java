import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

class bbhu
  implements anze
{
  bbhu(bbhp parambbhp) {}
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.a.c))
    {
      this.a.jdField_a_of_type_AndroidViewWindowManager.removeView(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.a.c = false;
      paramKeyEvent = this.a.getWindow().getAttributes();
      paramKeyEvent.y = 0;
      this.a.getWindow().setAttributes(paramKeyEvent);
      bbhp.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhu
 * JD-Core Version:    0.7.0.1
 */