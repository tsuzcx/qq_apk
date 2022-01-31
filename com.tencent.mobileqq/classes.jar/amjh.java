import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class amjh
{
  private amgo jdField_a_of_type_Amgo = new amgo();
  private amgt jdField_a_of_type_Amgt;
  private amgv jdField_a_of_type_Amgv;
  private boolean jdField_a_of_type_Boolean = true;
  
  public amjh()
  {
    this.jdField_a_of_type_Amgo.a(new amgq());
    this.jdField_a_of_type_Amgt = new amgt();
    this.jdField_a_of_type_Amgt.a(this.jdField_a_of_type_Amgo);
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 16908289;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Amgo != null) && (this.jdField_a_of_type_Amgv != null))
    {
      localColorNote = this.jdField_a_of_type_Amgv.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = amhh.a(localColorNote);
        this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
  
  public void a(amgo paramamgo)
  {
    this.jdField_a_of_type_Amgo = paramamgo;
  }
  
  public void a(amgq paramamgq)
  {
    if (this.jdField_a_of_type_Amgo != null) {
      this.jdField_a_of_type_Amgo.a(paramamgq);
    }
  }
  
  public void a(amgv paramamgv)
  {
    this.jdField_a_of_type_Amgv = paramamgv;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Amgo != null) && (this.jdField_a_of_type_Amgv != null))
    {
      localColorNote = this.jdField_a_of_type_Amgv.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = amhh.a(localColorNote);
        this.jdField_a_of_type_Amgo.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    if ((this.jdField_a_of_type_Amgv != null) && (this.jdField_a_of_type_Amgo != null) && (this.jdField_a_of_type_Amgt != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Amgv.getColorNote();
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
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Amgo.a(localObject.getServiceType(), localObject.getSubType())))
      {
        amhh.a(localObject);
        this.jdField_a_of_type_Amgt.a(localObject);
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
 * Qualified Name:     amjh
 * JD-Core Version:    0.7.0.1
 */