import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ch
{
  int jdField_a_of_type_Int;
  LiteActivity jdField_a_of_type_ComDatalineActivitiesLiteActivity;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public ch(LiteActivity paramLiteActivity1, LiteActivity paramLiteActivity2)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity2;
  }
  
  String a(Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(this.b.getApplicationContext(), paramUri);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (this.jdField_a_of_type_Int == -1) {
      return;
    }
    if (QLog.isColorLevel())
    {
      QLog.i(LiteActivity.a, 1, "sendMultipleFileWithFileProvider. [fileType] = " + this.jdField_a_of_type_Int);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QLog.i(LiteActivity.a, 1, "[filePath] = " + str);
      }
    }
    this.b.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(Intent paramIntent)
  {
    Bundle localBundle;
    Object localObject;
    try
    {
      localBundle = paramIntent.getExtras();
      if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {
        return;
      }
      paramIntent.putExtra("dataline_share_finish", true);
      localObject = paramIntent.getType();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      if (localBundle == null)
      {
        QLog.e(LiteActivity.a, 1, "LiteJumpAction:doShare type is [" + (String)localObject + "], action is [" + paramIntent.getAction() + "]");
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    if ((((String)localObject).startsWith("text")) && (!localBundle.containsKey("android.intent.extra.STREAM")))
    {
      paramIntent = localBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramIntent);
      return;
    }
    if (((String)localObject).startsWith("message"))
    {
      paramIntent = (SpannableString)localBundle.get("android.intent.extra.TEXT");
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramIntent.toString());
      return;
    }
    if (((String)localObject).startsWith("image"))
    {
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.a(this.b);
          return;
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent);
        a((ArrayList)localObject, true);
        return;
      }
      paramIntent = (ArrayList)localBundle.get("android.intent.extra.STREAM");
      if (paramIntent.size() > 50)
      {
        LiteActivity.b(this.b);
        return;
      }
      a(paramIntent, true);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SEND"))
    {
      paramIntent = (Uri)localBundle.get("android.intent.extra.STREAM");
      if (paramIntent == null)
      {
        LiteActivity.a(this.b);
        return;
      }
      if (((paramIntent instanceof Uri)) && ("text/x-vcard".equals(localObject)) && ("content".equals(paramIntent.getScheme())))
      {
        new ck(this.b).execute(new Object[] { this.b.getApplicationContext(), paramIntent });
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramIntent);
      a((ArrayList)localObject, false);
      return;
    }
    a((ArrayList)localBundle.get("android.intent.extra.STREAM"), false);
  }
  
  void a(ArrayList<Uri> paramArrayList, boolean paramBoolean)
  {
    int i = 1;
    if (paramArrayList == null)
    {
      LiteActivity.a(this.b);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str;
    if (paramArrayList.size() == 1)
    {
      str = a((Uri)paramArrayList.get(0));
      if ((TextUtils.isEmpty(str)) || (!new VFSFile(str).canRead()))
      {
        localArrayList.add(LiteActivity.a(this.b, (Uri)paramArrayList.get(0)));
        this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          this.jdField_a_of_type_Int = i;
          return;
        }
      }
      localArrayList.add(str);
      if (!paramBoolean) {
        break label183;
      }
    }
    for (;;)
    {
      this.b.a(localArrayList, i);
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        str = a((Uri)paramArrayList.next());
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
      break;
      label183:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ch
 * JD-Core Version:    0.7.0.1
 */