import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.NearbyProfileUtil.2;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;

public class bdda
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "男", "女" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845128, 2130845136 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "保密", "单身", "恋爱中", "已婚" };
    c = new String[] { "", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    d = new String[] { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
    e = new String[] { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130845485, 2130844525, 2130844525, 2130844525, 2130845244, 2130845244, 2130845502, 2130845502, 2130845026, 2130845026, 2130845026, 2130845485, 2130845485, 2130845305, 2130845485 };
  }
  
  public static final int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return jdField_a_of_type_ArrayOfInt[paramInt];
    }
    return 0;
  }
  
  public static final int a(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = j;
    flower_info.SFlowerInfoRsp localSFlowerInfoRsp;
    if (paramArrayOfByte != null) {
      localSFlowerInfoRsp = new flower_info.SFlowerInfoRsp();
    }
    try
    {
      localSFlowerInfoRsp.mergeFrom(paramArrayOfByte);
      i = j;
      if (localSFlowerInfoRsp.num.has()) {
        i = localSFlowerInfoRsp.num.get();
      }
      return i;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  private static final long a()
  {
    return 0L | 0x4 | 0x800 | 0x1000 | 0x8000;
  }
  
  public static final String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_b_of_type_ArrayOfJavaLangString.length)) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "";
  }
  
  public static final void a(auxh paramauxh, QQAppInterface paramQQAppInterface, long paramLong1, String paramString, int paramInt1, byte[] paramArrayOfByte, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, long paramLong4, int paramInt2)
  {
    if (paramLong1 > 0L)
    {
      if (ProfileActivity.d(paramInt1))
      {
        paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 45, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (ProfileActivity.b(paramInt1))
      {
        paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 39, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 16)
      {
        paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 46, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 38)
      {
        paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 47, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 100)
      {
        paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 49, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 51)
      {
        paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 51, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), "0", 41, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
    }
    if (paramString.equals(paramQQAppInterface.getCurrentAccountUin()))
    {
      paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentAccountUin(), 0, 0L, (byte)0, 0L, 0L, null, "", a(), 10004, null, 0L, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
    }
    int i = 6;
    if (ProfileActivity.c(paramInt1)) {
      i = 42;
    }
    for (;;)
    {
      paramauxh.a(paramQQAppInterface.getCurrentAccountUin(), paramString, i, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, 0L, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
      if (ProfileActivity.d(paramInt1)) {
        i = 45;
      } else if (ProfileActivity.b(paramInt1)) {
        i = 39;
      } else if (paramInt1 == 16) {
        i = 46;
      } else if (paramInt1 == 38) {
        i = 47;
      } else if (paramInt1 == 51) {
        i = 51;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localBundle.putShort("key_flower_visible_switch", (short)i);
      localBundle.putBoolean("key_nearby_people_card_force_update", true);
      auxh localauxh = (auxh)paramQQAppInterface.a(60);
      if (localauxh == null) {
        break;
      }
      paramQQAppInterface.a(new NearbyProfileUtil.2(localauxh, localBundle));
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -1) || ((paramInt >= 0) && (paramInt < d.length));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    awgf localawgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = null;
    Object localObject = null;
    if (localawgf != null)
    {
      paramQQAppInterface = localObject;
      if (!bdnn.a(str)) {
        paramQQAppInterface = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { str });
      }
      localawgf.a();
    }
    boolean bool;
    if (paramQQAppInterface != null) {
      if (paramQQAppInterface.switchGiftVisible == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public static final int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return jdField_b_of_type_ArrayOfInt[paramInt];
    }
    return 0;
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "";
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    if (ProfileActivity.c(paramInt)) {
      return 3;
    }
    if (paramInt == 21) {
      return 4;
    }
    if (ProfileActivity.d(paramInt)) {
      return 5;
    }
    return 99;
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return c[paramInt];
    }
    return "";
  }
  
  public static final String d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return e[paramInt];
    }
    return "";
  }
  
  public static final String e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 14)) {
      return d[paramInt];
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdda
 * JD-Core Version:    0.7.0.1
 */