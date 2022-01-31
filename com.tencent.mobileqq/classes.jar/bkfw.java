import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;

public abstract class bkfw<PACKAGE extends bkfi>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  protected bjcd a;
  protected PACKAGE a;
  protected FaceListPage a;
  
  public bkfw(Context paramContext, FaceListPage paramFaceListPage)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage = paramFaceListPage;
  }
  
  public void a(bjcd parambjcd)
  {
    this.jdField_a_of_type_Bjcd = parambjcd;
  }
  
  public void a(PACKAGE paramPACKAGE)
  {
    this.jdField_a_of_type_Bkfi = paramPACKAGE;
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage.a;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Bkfi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceList", 2, "facePkg is null");
      }
      return 0;
    }
    int i = this.jdField_a_of_type_Bkfi.b();
    int j = this.jdField_a_of_type_Bkfi.a();
    if (j < 1) {
      throw new IllegalArgumentException("per item count < 1 :" + j);
    }
    if ((QLog.isColorLevel()) && (i == 0)) {
      QLog.d("FaceList", 2, "totalFaceCount = 0");
    }
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkfw
 * JD-Core Version:    0.7.0.1
 */