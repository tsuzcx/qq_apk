import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

public class aoer
{
  private aobx jdField_a_of_type_Aobx = new aobx();
  private aocd jdField_a_of_type_Aocd;
  private aocf jdField_a_of_type_Aocf;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aoer()
  {
    this.jdField_a_of_type_Aobx.a(new aobz());
    this.jdField_a_of_type_Aocd = new aocd();
    this.jdField_a_of_type_Aocd.a(this.jdField_a_of_type_Aobx);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aobx != null) && (this.jdField_a_of_type_Aocf != null))
    {
      localColorNote = this.jdField_a_of_type_Aocf.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = aocr.a(localColorNote);
        this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
  
  public void a(aobx paramaobx)
  {
    this.jdField_a_of_type_Aobx = paramaobx;
  }
  
  public void a(aobz paramaobz)
  {
    if (this.jdField_a_of_type_Aobx != null) {
      this.jdField_a_of_type_Aobx.a(paramaobz);
    }
  }
  
  public void a(aocf paramaocf)
  {
    this.jdField_a_of_type_Aocf = paramaocf;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aobx != null) && (this.jdField_a_of_type_Aocf != null))
    {
      localColorNote = this.jdField_a_of_type_Aocf.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = aocr.a(localColorNote);
        this.jdField_a_of_type_Aobx.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    if ((this.jdField_a_of_type_Aocf != null) && (this.jdField_a_of_type_Aobx != null) && (this.jdField_a_of_type_Aocd != null)) {
      localObject = null;
    }
    try
    {
      ColorNote localColorNote = this.jdField_a_of_type_Aocf.getColorNote();
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
      if ((localObject != null) && (i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Aobx.a(localObject.getServiceType(), localObject.getSubType())))
      {
        aocr.a(localObject);
        this.jdField_a_of_type_Aocd.a(localObject);
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
 * Qualified Name:     aoer
 * JD-Core Version:    0.7.0.1
 */