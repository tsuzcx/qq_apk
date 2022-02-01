import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atbk
  extends atfq
{
  public atbk(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    super.a(paramInt, paramString1, paramString2);
    this.a.c(false);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    auea.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2)
  {
    QfileCloudFileTabView.b(this.a, true);
    QfileCloudFileTabView.c(this.a, paramBoolean);
    this.a.jdField_c_of_type_Int = paramInt2;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      paramInt1 = auea.a(localWeiYunFileInfo.jdField_c_of_type_JavaLangString);
      String str;
      if (paramInt1 == 0)
      {
        str = QfileCloudFileTabView.a(this.a).getFileManagerEngine().a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.e, 3, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
      else if (2 == paramInt1)
      {
        str = QfileCloudFileTabView.b(this.a).getFileManagerEngine().b(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo.e, 2, localWeiYunFileInfo);
        if (str != null) {
          localWeiYunFileInfo.h = str;
        }
      }
    }
    if (!paramString1.equals(this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QfileCloudFileTabView.b(this.a)) {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (!this.a.jdField_a_of_type_JavaLangString.equalsIgnoreCase("picture")) {
      this.a.setListFooter();
    }
    this.a.jdField_c_of_type_JavaLangString = paramString2;
    this.a.jdField_c_of_type_Boolean = true;
    this.a.g();
    this.a.a();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Atab.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbk
 * JD-Core Version:    0.7.0.1
 */