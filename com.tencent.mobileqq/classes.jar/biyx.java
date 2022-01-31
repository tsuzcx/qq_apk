import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import cooperation.qqreader.QRBridgeActivity;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class biyx
{
  private static final biyx jdField_a_of_type_Biyx = new biyx();
  private int jdField_a_of_type_Int = 300;
  private long jdField_a_of_type_Long = 100L;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 300;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 100;
  private boolean jdField_c_of_type_Boolean = true;
  
  private biyx()
  {
    a(bjbp.a(BaseApplicationImpl.getContext()));
    a();
  }
  
  public static biyx a()
  {
    return jdField_a_of_type_Biyx;
  }
  
  private void a()
  {
    bjcd.a(bjcd.b, new biyy(this), true);
  }
  
  private void a(String paramString)
  {
    label155:
    label158:
    label161:
    do
    {
      for (;;)
      {
        int i;
        try
        {
          JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("configs");
          paramString = null;
          i = 0;
          if (i >= localJSONArray.length()) {
            break label158;
          }
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          String str = localJSONObject.getString("version");
          if ("*".equals(str))
          {
            paramString = localJSONObject;
            break label161;
          }
          if (!str.contains("8.3.5")) {
            break label155;
          }
          paramString = localJSONObject;
        }
        catch (Exception paramString)
        {
          bjbl.a("QRLocalManager", "json parse err", paramString);
          return;
        }
        this.jdField_a_of_type_Boolean = paramString.optBoolean("aioEntryEnable");
        this.jdField_b_of_type_Boolean = paramString.optBoolean("previewEntryEnable");
        this.jdField_c_of_type_Boolean = paramString.optBoolean("moreEntryEnable");
        this.jdField_a_of_type_Long = paramString.optInt("aioFileSizeLimit");
        this.jdField_a_of_type_Int = paramString.optInt("addBookshelfDuration");
        this.jdField_b_of_type_Int = paramString.optInt("goBookshelfDuration");
        this.jdField_c_of_type_Int = paramString.optInt("splitChapterParaMaxNum");
        return;
        break label161;
        break;
        i += 1;
      }
    } while (paramString != null);
  }
  
  private boolean a()
  {
    if (!biyz.a().a())
    {
      biyz.a().a();
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
    if ((paramFileManagerEntity.status != 1) || (TextUtils.isEmpty(paramFileManagerEntity.strFilePath))) {
      return false;
    }
    return a(paramFileManagerEntity.strFilePath, paramFileManagerEntity.fileSize);
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
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyx
 * JD-Core Version:    0.7.0.1
 */