import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aqfc
{
  private aqcc jdField_a_of_type_Aqcc = new aqcc();
  private aqci jdField_a_of_type_Aqci;
  private aqck jdField_a_of_type_Aqck;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aqfc()
  {
    this.jdField_a_of_type_Aqcc.a(new aqce());
    this.jdField_a_of_type_Aqci = new aqci();
    this.jdField_a_of_type_Aqci.a(this.jdField_a_of_type_Aqcc);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aqcc != null) && (this.jdField_a_of_type_Aqck != null))
    {
      localColorNote = this.jdField_a_of_type_Aqck.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqcc.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = aqda.a(localColorNote);
        this.jdField_a_of_type_Aqcc.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
  
  public void a(aqcc paramaqcc)
  {
    this.jdField_a_of_type_Aqcc = paramaqcc;
  }
  
  public void a(aqce paramaqce)
  {
    if (this.jdField_a_of_type_Aqcc != null) {
      this.jdField_a_of_type_Aqcc.a(paramaqce);
    }
  }
  
  public void a(aqck paramaqck)
  {
    this.jdField_a_of_type_Aqck = paramaqck;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aqcc != null) && (this.jdField_a_of_type_Aqck != null))
    {
      localColorNote = this.jdField_a_of_type_Aqck.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aqcc.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = aqda.a(localColorNote);
        this.jdField_a_of_type_Aqcc.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    if ((this.jdField_a_of_type_Aqck != null) && (this.jdField_a_of_type_Aqcc != null) && (this.jdField_a_of_type_Aqci != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aqck.getColorNote();
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
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Aqcc.a(localObject.getServiceType(), localObject.getSubType())))
      {
        aqda.a(localObject);
        this.jdField_a_of_type_Aqci.a(localObject);
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
 * Qualified Name:     aqfc
 * JD-Core Version:    0.7.0.1
 */