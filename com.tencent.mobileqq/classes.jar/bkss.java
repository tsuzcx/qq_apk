import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import cooperation.qqreader.QRBridgeActivity;
import java.io.File;

public class bkss
{
  private static final bkss jdField_a_of_type_Bkss = new bkss();
  private int jdField_a_of_type_Int = 300;
  private long jdField_a_of_type_Long = 100L;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 300;
  private boolean jdField_b_of_type_Boolean;
  private int c = 100;
  
  public static bkss a()
  {
    return jdField_a_of_type_Bkss;
  }
  
  private boolean a()
  {
    if (!bkst.a().a())
    {
      bkst.a().a();
      return false;
    }
    return true;
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Intent localIntent1 = new Intent(paramContext, QRBridgeActivity.class);
    localIntent1.putExtra("readtype", "31");
    localIntent1.putExtra("stay", "1");
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("com.qqreader.pureader.FILE_PATH", paramString);
    if (paramBoolean) {
      localIntent2.putExtra("ChannelID", "100328");
    }
    for (;;)
    {
      localIntent1.putExtras(localIntent2);
      paramContext.startActivity(localIntent1);
      return;
      localIntent2.putExtra("ChannelID", "100330");
    }
  }
  
  public boolean a(@NonNull FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.status != 1) || (TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return false;
    }
    return a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize);
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if (paramLong < this.jdField_a_of_type_Long * 1024L) {}
    while ((!this.jdField_a_of_type_Boolean) || (!a()) || (TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return false;
    }
    return paramString.toLowerCase().endsWith(".txt");
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while (!paramFileManagerEntity.fileName.toLowerCase().endsWith(".txt")) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkss
 * JD-Core Version:    0.7.0.1
 */