import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody.Item;

public final class bfrs
{
  public int a;
  public long a;
  public final String a;
  public Map<String, bfrs> a;
  public UUID a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  private int i;
  public transient String i;
  public transient String j;
  public transient String k;
  public String l;
  public String m;
  public String n;
  
  public bfrs()
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 7;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public bfrs(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 7;
    a(paramFileInfo);
  }
  
  public bfrs(group_file_common.FolderInfo paramFolderInfo)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 7;
    a(paramFolderInfo);
  }
  
  public bfrs(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_e_of_type_Int = 7;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_e_of_type_Int = 7;
    a(paramItem);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = bhsw.b(paramContext, paramLong);
    paramContext = str;
    int i1;
    int i2;
    if (str != null)
    {
      i1 = bhsw.d(paramLong);
      i2 = str.indexOf(" ");
      paramContext = str;
      if (i2 != -1)
      {
        paramContext = str;
        if (i2 < str.length() - 1)
        {
          if (i1 != 1) {
            break label70;
          }
          paramContext = str.substring(i2 + 1);
        }
      }
    }
    label70:
    do
    {
      return paramContext;
      str = str.substring(0, i2);
      paramContext = str;
    } while (i1 != 5);
    return str.substring(2);
  }
  
  private String a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int i5 = 1;
    int i4 = 0;
    if (!paramBoolean) {}
    for (;;)
    {
      int i1;
      try
      {
        if (this.n == null)
        {
          break label301;
          if (i1 != 0)
          {
            this.n = bhlg.a(paramQQAppInterface, b(), paramLong + "", 1, 0);
            if (this.n.length() <= 10)
            {
              i1 = i5;
              break label307;
              if (i2 >= this.n.length()) {
                break label292;
              }
              if (Character.isDigit(this.n.charAt(i2))) {
                continue;
              }
              i1 = i4;
              if ((TextUtils.isEmpty(this.n)) || (i1 != 0)) {
                this.n = this.jdField_e_of_type_JavaLangString;
              }
              this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
            }
          }
          else
          {
            paramQQAppInterface = this.n;
            return paramQQAppInterface;
          }
        }
        else
        {
          if (SystemClock.uptimeMillis() - this.jdField_e_of_type_Long > 300000L)
          {
            i1 = 1;
            continue;
          }
          if (this.n.length() <= 10)
          {
            i1 = 1;
            break label318;
            i3 = i1;
            if (i2 < this.n.length())
            {
              if (!Character.isDigit(this.n.charAt(i2))) {
                i3 = 0;
              }
            }
            else
            {
              if (i3 == 0) {
                break label295;
              }
              long l1 = SystemClock.uptimeMillis();
              long l2 = this.jdField_e_of_type_Long;
              if (l1 - l2 <= 3000L) {
                break label295;
              }
              i1 = 1;
            }
          }
          else
          {
            i1 = 0;
            break label318;
          }
          i2 += 1;
          continue;
        }
        i1 = 0;
        break label307;
        i2 += 1;
        continue;
        continue;
      }
      finally {}
      label292:
      label295:
      label301:
      label307:
      do
      {
        i1 = 0;
        break;
        i1 = 1;
        break;
      } while (i1 == 0);
      int i2 = 0;
      continue;
      label318:
      int i3 = i1;
      if (i1 != 0) {
        i2 = 0;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return bgsk.a(this.jdField_a_of_type_Long);
  }
  
  public String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return bhlg.a(paramQQAppInterface, b(), paramLong + "", 1, 0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.l = a(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_Int * 1000L);
  }
  
  public void a(bfrs parambfrs)
  {
    if (parambfrs != null)
    {
      if ((parambfrs.jdField_e_of_type_Int != 8) && (parambfrs.jdField_e_of_type_Int != 9)) {
        break label45;
      }
      if (parambfrs.jdField_b_of_type_JavaLangString != null) {
        this.jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
      }
    }
    label45:
    while (((parambfrs.jdField_e_of_type_Int != 11) && (parambfrs.jdField_e_of_type_Int != 10) && (parambfrs.jdField_e_of_type_Int != 12)) || (parambfrs.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove(parambfrs.jdField_b_of_type_JavaLangString);
  }
  
  public void a(bftf parambftf, QQAppInterface paramQQAppInterface)
  {
    this.jdField_i_of_type_JavaLangString = parambftf.jdField_b_of_type_JavaLangString;
    this.j = parambftf.jdField_c_of_type_JavaLangString;
    this.k = parambftf.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_Int = parambftf.jdField_b_of_type_Int;
    this.jdField_h_of_type_JavaLangString = parambftf.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_Long = parambftf.jdField_d_of_type_Long;
    this.jdField_f_of_type_Int = parambftf.jdField_c_of_type_Int;
    this.jdField_c_of_type_Boolean = parambftf.jdField_a_of_type_Boolean;
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_b_of_type_Int = parambftf.jdField_d_of_type_Int;
      this.l = a(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_Int * 1000L);
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = parambftf.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_f_of_type_JavaLangString == null) {
      this.jdField_f_of_type_JavaLangString = parambftf.jdField_i_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = parambftf.jdField_c_of_type_Long;
    }
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = parambftf.jdField_g_of_type_JavaLangString;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bfrt.a(parambftf.jdField_b_of_type_Int))) {
      this.jdField_a_of_type_Int = parambftf.jdField_h_of_type_Int;
    }
    if ((this.jdField_b_of_type_Long == 0L) && (bfrt.a(parambftf.jdField_b_of_type_Int))) {}
    try
    {
      this.jdField_b_of_type_Long = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (NumberFormatException parambftf)
    {
      QLog.e("TroopFileInfo", 4, "updateItemStatus NumberFormatException");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_e_of_type_JavaLangString = a(paramQQAppInterface, paramLong, false);
  }
  
  public void a(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramFileInfo.str_file_path.get();
    this.jdField_c_of_type_JavaLangString = paramFileInfo.str_file_name.get();
    this.jdField_a_of_type_Long = paramFileInfo.uint64_file_size.get();
    this.jdField_a_of_type_Int = paramFileInfo.uint32_bus_id.get();
    this.jdField_b_of_type_Long = paramFileInfo.uint32_upload_uin.get();
    this.jdField_c_of_type_Long = paramFileInfo.uint64_uploaded_size.get();
    this.jdField_b_of_type_Int = paramFileInfo.uint32_upload_time.get();
    this.jdField_c_of_type_Int = paramFileInfo.uint32_dead_time.get();
    this.jdField_i_of_type_Int = paramFileInfo.uint32_modify_time.get();
    this.jdField_d_of_type_Int = paramFileInfo.uint32_download_times.get();
    this.jdField_e_of_type_JavaLangString = paramFileInfo.str_uploader_name.get();
    this.jdField_d_of_type_JavaLangString = new String(paramFileInfo.bytes_sha.get().toByteArray());
    this.m = a(BaseApplicationImpl.getApplication(), this.jdField_i_of_type_Int * 1000L);
    this.l = a(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_Int * 1000L);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(group_file_common.FolderInfo paramFolderInfo)
  {
    if (paramFolderInfo == null) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramFolderInfo.str_folder_id.get();
    this.jdField_c_of_type_JavaLangString = paramFolderInfo.str_folder_name.get();
    this.jdField_b_of_type_Int = paramFolderInfo.uint32_create_time.get();
    this.jdField_i_of_type_Int = paramFolderInfo.uint32_modify_time.get();
    this.jdField_b_of_type_Long = paramFolderInfo.uint64_create_uin.get();
    this.jdField_f_of_type_JavaLangString = "/";
    this.jdField_h_of_type_Int = paramFolderInfo.uint32_total_file_count.get();
    this.l = a(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_Int * 1000L);
    this.m = a(BaseApplicationImpl.getApplication(), this.jdField_i_of_type_Int * 1000L);
  }
  
  public void a(oidb_0x6d8.GetFileListRspBody.Item paramItem)
  {
    if (paramItem == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    switch (paramItem.uint32_type.get())
    {
    default: 
      return;
    case 1: 
      this.jdField_d_of_type_Boolean = false;
      paramItem = (group_file_common.FileInfo)paramItem.file_info.get();
      this.jdField_b_of_type_JavaLangString = paramItem.str_file_id.get();
      this.jdField_c_of_type_JavaLangString = paramItem.str_file_name.get();
      this.jdField_a_of_type_Long = paramItem.uint64_file_size.get();
      this.jdField_a_of_type_Int = paramItem.uint32_bus_id.get();
      this.jdField_b_of_type_Long = paramItem.uint64_uploader_uin.get();
      this.jdField_c_of_type_Long = paramItem.uint64_uploaded_size.get();
      this.jdField_b_of_type_Int = paramItem.uint32_upload_time.get();
      this.jdField_c_of_type_Int = paramItem.uint32_dead_time.get();
      this.jdField_i_of_type_Int = paramItem.uint32_modify_time.get();
      this.jdField_d_of_type_Int = paramItem.uint32_download_times.get();
      this.jdField_e_of_type_JavaLangString = paramItem.str_uploader_name.get();
      this.jdField_d_of_type_JavaLangString = new String(paramItem.bytes_sha.get().toByteArray());
      this.jdField_f_of_type_JavaLangString = paramItem.str_parent_folder_id.get();
      this.l = a(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_Int * 1000L);
      this.m = a(BaseApplicationImpl.getApplication(), this.jdField_i_of_type_Int * 1000L);
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    paramItem = (group_file_common.FolderInfo)paramItem.folder_info.get();
    this.jdField_b_of_type_JavaLangString = paramItem.str_folder_id.get();
    this.jdField_c_of_type_JavaLangString = paramItem.str_folder_name.get();
    this.jdField_i_of_type_Int = paramItem.uint32_modify_time.get();
    this.jdField_b_of_type_Int = paramItem.uint32_create_time.get();
    this.jdField_b_of_type_Long = paramItem.uint64_create_uin.get();
    this.jdField_f_of_type_JavaLangString = paramItem.str_parent_folder_id.get();
    this.jdField_h_of_type_Int = paramItem.uint32_total_file_count.get();
    this.l = a(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_Int * 1000L);
    this.m = a(BaseApplicationImpl.getApplication(), this.jdField_i_of_type_Int * 1000L);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (bgsk.a(paramQQAppInterface, paramLong)) && (this.jdField_d_of_type_Boolean);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool1 = paramQQAppInterface.getCurrentAccountUin().equals(b());
    boolean bool2 = bgsk.a(paramQQAppInterface, paramLong);
    switch (this.jdField_e_of_type_Int)
    {
    }
    do
    {
      do
      {
        return false;
        if (this.jdField_d_of_type_Boolean) {
          return bool2;
        }
      } while ((!bool2) && (!bool1));
      return true;
      if (this.jdField_d_of_type_Boolean) {
        return bool2;
      }
      return true;
    } while (!paramBoolean);
    if (this.jdField_d_of_type_Boolean) {
      return bool2;
    }
    return true;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_Long + "";
  }
  
  public void b(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    this.m = a(BaseApplicationImpl.getApplication(), this.jdField_i_of_type_Int * 1000L);
  }
  
  public void b(bfrs parambfrs)
  {
    if (parambfrs == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = parambfrs.jdField_b_of_type_JavaLangString;
    this.jdField_f_of_type_JavaLangString = parambfrs.jdField_f_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = parambfrs.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Int = parambfrs.jdField_a_of_type_Int;
    this.jdField_b_of_type_Long = parambfrs.jdField_b_of_type_Long;
    this.jdField_c_of_type_Long = parambfrs.jdField_c_of_type_Long;
    this.jdField_a_of_type_Long = parambfrs.jdField_a_of_type_Long;
    this.jdField_b_of_type_Int = parambfrs.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = parambfrs.jdField_c_of_type_Int;
    this.jdField_i_of_type_Int = parambfrs.jdField_i_of_type_Int;
    this.jdField_d_of_type_Int = parambfrs.jdField_d_of_type_Int;
    this.jdField_e_of_type_JavaLangString = parambfrs.jdField_e_of_type_JavaLangString;
    this.jdField_h_of_type_Int = parambfrs.jdField_h_of_type_Int;
    this.jdField_d_of_type_JavaLangString = parambfrs.jdField_d_of_type_JavaLangString;
    this.jdField_d_of_type_Boolean = parambfrs.jdField_d_of_type_Boolean;
    this.l = parambfrs.l;
    this.m = parambfrs.m;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    return (bgsk.a(paramQQAppInterface, paramLong)) && (!this.jdField_d_of_type_Boolean) && (!paramBoolean) && (!bfrt.a(this.jdField_e_of_type_Int)) && (!bfrt.b(this.jdField_e_of_type_Int));
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof bfrs))) {
      return false;
    }
    paramObject = (bfrs)paramObject;
    return this.jdField_a_of_type_JavaUtilUUID.equals(paramObject.jdField_a_of_type_JavaUtilUUID);
  }
  
  public String toString()
  {
    return "TroopFileInfo{TAG='TroopFileInfo', Id=" + this.jdField_a_of_type_JavaUtilUUID + ", str_file_path='" + this.jdField_b_of_type_JavaLangString + '\'' + ", str_file_name='" + this.jdField_c_of_type_JavaLangString + '\'' + ", uint64_file_size=" + this.jdField_a_of_type_Long + ", uint32_bus_id=" + this.jdField_a_of_type_Int + ", uint32_upload_uin=" + this.jdField_b_of_type_Long + ", uint64_uploaded_size=" + this.jdField_c_of_type_Long + ", uint32_upload_time=" + this.jdField_b_of_type_Int + ", uint32_dead_time=" + this.jdField_c_of_type_Int + ", uint32_modify_time=" + this.jdField_i_of_type_Int + ", uint32_download_times=" + this.jdField_d_of_type_Int + ", str_uploader_name='" + this.jdField_e_of_type_JavaLangString + '\'' + ", Status=" + this.jdField_e_of_type_Int + ", _sStatus='" + this.jdField_g_of_type_JavaLangString + '\'' + ", ProgressValue=" + this.jdField_d_of_type_Long + ", ErrorCode=" + this.jdField_f_of_type_Int + ", LocalFile='" + this.jdField_h_of_type_JavaLangString + '\'' + ", UploadCreateTime=" + this.jdField_g_of_type_Int + ", Unread=" + this.jdField_a_of_type_Boolean + ", ThumbnailFile_Small='" + this.jdField_i_of_type_JavaLangString + '\'' + ", ThumbnailFile_Large='" + this.j + '\'' + ", IsGhost=" + this.jdField_b_of_type_Boolean + ", IsNewStatus=" + this.jdField_c_of_type_Boolean + ", NickName='" + this.n + '\'' + ", lastNickNameUpdateMS=" + this.jdField_e_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfrs
 * JD-Core Version:    0.7.0.1
 */