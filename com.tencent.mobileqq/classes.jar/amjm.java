import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class amjm
  extends Observable
{
  protected int a;
  protected long a;
  public amjq a;
  protected amjt a;
  public QQAppInterface a;
  public FTSDatabase a;
  protected FTSDatatbase a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  private boolean c;
  
  public amjm(QQAppInterface paramQQAppInterface, amjq paramamjq)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amjq = paramamjq;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(50);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" ").append(getClass().getSimpleName()).append(" transCount:").append(this.jdField_c_of_type_Int).append(" transCost:").append(this.jdField_a_of_type_Long).append(" transAvg:");
    if (this.jdField_c_of_type_Int != 0) {}
    for (float f = (float)this.jdField_a_of_type_Long * 1.0F / this.jdField_c_of_type_Int;; f = 0.0F)
    {
      localStringBuilder2.append(f);
      this.jdField_a_of_type_Long = 0L;
      this.jdField_c_of_type_Int = 0;
      return localStringBuilder1.toString();
    }
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Amjt != null) {
      this.jdField_a_of_type_Amjt.a();
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  public boolean a()
  {
    if (bdli.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) {}
    while (this.jdField_a_of_type_Amjt == null) {
      return false;
    }
    return this.jdField_a_of_type_Amjt.a();
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = paramFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase = paramFTSDatabase;
    return true;
  }
  
  public void b()
  {
    if (a()) {
      b();
    }
  }
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null) {
      deleteObserver(paramObserver);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amjt != null) {
      return this.jdField_a_of_type_Amjt.b();
    }
    return true;
  }
  
  public void c()
  {
    setChanged();
    notifyObservers();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Amjq.obtainMessage(2, this).sendToTarget();
  }
  
  protected boolean d()
  {
    boolean bool3 = false;
    int i;
    boolean bool1;
    if (!this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
        if (i == 0)
        {
          this.jdField_c_of_type_Boolean = true;
          bool1 = false;
          label39:
          bool2 = bool1;
          if (i == 1) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((bool2) && (e()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.sync_worker", 2, "isSaveDBAtOnce unActionLoginB atOnce:" + bool1);
        }
        return bool1;
      }
      bool1 = true;
      break label39;
      i = 0;
      break;
    }
  }
  
  public abstract void e();
  
  protected boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjm
 * JD-Core Version:    0.7.0.1
 */