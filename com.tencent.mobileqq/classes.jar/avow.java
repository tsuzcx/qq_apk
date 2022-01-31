import android.os.Handler;
import android.os.Message;
import com.tencent.widget.AbsListView;

class avow
  implements bhpo
{
  private avow(avot paramavot) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    bhpo localbhpo = this.a.jdField_a_of_type_Avos.a();
    if (localbhpo != null) {
      localbhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int j = 0;
    int i;
    Object localObject;
    if ((this.a.jdField_a_of_type_Int == 2) && (paramInt != 2))
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this.a);
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (!this.a.b) {
        break label129;
      }
      i = j;
      label66:
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, i);
      this.a.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = paramInt;
      localObject = this.a.jdField_a_of_type_Avos.a();
      if (localObject != null) {
        ((bhpo)localObject).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      i = 0;
      break;
      label129:
      i = 550;
      break label66;
      label136:
      if (paramInt == 2)
      {
        this.a.jdField_a_of_type_Boolean = false;
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avow
 * JD-Core Version:    0.7.0.1
 */