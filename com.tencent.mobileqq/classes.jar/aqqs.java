import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aqqs
{
  private aqns jdField_a_of_type_Aqns = new aqns();
  private aqny jdField_a_of_type_Aqny;
  private aqoa jdField_a_of_type_Aqoa;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aqqs()
  {
    this.jdField_a_of_type_Aqns.a(new aqnu());
    this.jdField_a_of_type_Aqny = new aqny();
    this.jdField_a_of_type_Aqny.a(this.jdField_a_of_type_Aqns);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292) || (paramInt == 16842752);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aqns != null) && (this.jdField_a_of_type_Aqoa != null))
    {
      localColorNote = this.jdField_a_of_type_Aqoa.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = aqoq.a(localColorNote);
        this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
  
  public void a(aqns paramaqns)
  {
    this.jdField_a_of_type_Aqns = paramaqns;
  }
  
  public void a(aqnu paramaqnu)
  {
    if (this.jdField_a_of_type_Aqns != null) {
      this.jdField_a_of_type_Aqns.a(paramaqnu);
    }
  }
  
  public void a(aqoa paramaqoa)
  {
    this.jdField_a_of_type_Aqoa = paramaqoa;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqns != null) && (this.jdField_a_of_type_Aqoa != null))
    {
      localColorNote = this.jdField_a_of_type_Aqoa.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = aqoq.a(localColorNote);
        this.jdField_a_of_type_Aqns.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    if ((this.jdField_a_of_type_Aqoa != null) && (this.jdField_a_of_type_Aqns != null) && (this.jdField_a_of_type_Aqny != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqoa.getColorNote();
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
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Aqns.a(localObject.getServiceType(), localObject.getSubType())))
      {
        aqoq.a(localObject);
        this.jdField_a_of_type_Aqny.a(localObject);
      }
      return;
    }
  }
  
  public void c()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqs
 * JD-Core Version:    0.7.0.1
 */