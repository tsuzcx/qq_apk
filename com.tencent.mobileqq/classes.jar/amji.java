import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class amji
{
  private amgp jdField_a_of_type_Amgp = new amgp();
  private amgu jdField_a_of_type_Amgu;
  private amgw jdField_a_of_type_Amgw;
  private boolean jdField_a_of_type_Boolean = true;
  
  public amji()
  {
    this.jdField_a_of_type_Amgp.a(new amgr());
    this.jdField_a_of_type_Amgu = new amgu();
    this.jdField_a_of_type_Amgu.a(this.jdField_a_of_type_Amgp);
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 16908289;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Amgp != null) && (this.jdField_a_of_type_Amgw != null))
    {
      localColorNote = this.jdField_a_of_type_Amgw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = amhi.a(localColorNote);
        this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void a(amgp paramamgp)
  {
    this.jdField_a_of_type_Amgp = paramamgp;
  }
  
  public void a(amgr paramamgr)
  {
    if (this.jdField_a_of_type_Amgp != null) {
      this.jdField_a_of_type_Amgp.a(paramamgr);
    }
  }
  
  public void a(amgw paramamgw)
  {
    this.jdField_a_of_type_Amgw = paramamgw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Amgp != null) && (this.jdField_a_of_type_Amgw != null))
    {
      localColorNote = this.jdField_a_of_type_Amgw.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = amhi.a(localColorNote);
        this.jdField_a_of_type_Amgp.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Amgw != null) && (this.jdField_a_of_type_Amgp != null) && (this.jdField_a_of_type_Amgu != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Amgw.getColorNote();
      localObject = localColorNote;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteStateNotice", 1, localException, new Object[0]);
        continue;
        int i = 0;
      }
    }
    if ((localObject != null) && (a(localObject.getServiceType())))
    {
      i = 1;
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Amgp.a(localObject.getServiceType(), localObject.getSubType())))
      {
        amhi.a(localObject);
        this.jdField_a_of_type_Amgu.a(localObject);
      }
      return;
    }
  }
  
  public void c()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amji
 * JD-Core Version:    0.7.0.1
 */