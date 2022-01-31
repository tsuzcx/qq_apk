import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class bhbm
{
  public int a;
  public long a;
  public String a;
  public ArrayList<QZoneCountUserInfo> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public bhbm()
  {
    this(0, 0, new ArrayList(), "", "");
  }
  
  public bhbm(int paramInt1, int paramInt2, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public bhbm(bhbm parambhbm)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = parambhbm.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = parambhbm.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (parambhbm.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(parambhbm.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaLangString = parambhbm.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = parambhbm.jdField_d_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = parambhbm.jdField_c_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambhbm.jdField_b_of_type_JavaLangString;
    this.e = parambhbm.e;
    this.jdField_c_of_type_Int = parambhbm.jdField_c_of_type_Int;
    this.f = parambhbm.f;
    this.g = parambhbm.g;
    this.jdField_b_of_type_Long = parambhbm.jdField_b_of_type_Long;
    this.jdField_d_of_type_Int = parambhbm.jdField_d_of_type_Int;
    this.jdField_b_of_type_Boolean = parambhbm.jdField_b_of_type_Boolean;
  }
  
  public static HashMap<Integer, bhbm> a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (paramCursor.moveToNext())
    {
      bhbm localbhbm = new bhbm();
      int j = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      localbhbm.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("icontrol"));
      localbhbm.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("friendMsg"));
      localbhbm.jdField_a_of_type_Long = paramCursor.getInt(paramCursor.getColumnIndex("ucount"));
      localbhbm.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("trace_info"));
      localbhbm.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("friendsNum"));
      localbhbm.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject1 = paramCursor.getBlob(paramCursor.getColumnIndex("frienduins"));
      Parcel localParcel;
      if ((localObject1 != null) && (localObject1.length != 0)) {
        localParcel = Parcel.obtain();
      }
      try
      {
        localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
        localParcel.setDataPosition(0);
        localObject1 = localParcel.readParcelableArray(QZoneCountUserInfo.class.getClassLoader());
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            localbhbm.jdField_a_of_type_JavaUtilArrayList.add((QZoneCountUserInfo)localObject2);
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label295:
          localThrowable.printStackTrace();
          localParcel.recycle();
        }
      }
      finally
      {
        localParcel.recycle();
      }
      if (paramCursor.getInt(paramCursor.getColumnIndex("existDL")) == 1)
      {
        bool = true;
        localbhbm.jdField_a_of_type_Boolean = bool;
        localbhbm.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("pushMsg"));
        localbhbm.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("schema"));
        localbhbm.e = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        localbhbm.g = paramCursor.getString(paramCursor.getColumnIndex("reportValue"));
        localbhbm.f = paramCursor.getString(paramCursor.getColumnIndex("showMsg"));
        localbhbm.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("countID"));
        localbhbm.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("cTime"));
        localbhbm.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("iShowLevel"));
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasShow")) != 1) {
          break label526;
        }
      }
      label526:
      for (boolean bool = true;; bool = false)
      {
        localbhbm.jdField_b_of_type_Boolean = bool;
        localHashMap.put(Integer.valueOf(j), localbhbm);
        break;
        bool = false;
        break label295;
      }
    }
    return localHashMap;
  }
  
  public ContentValues a()
  {
    int j = 1;
    ContentValues localContentValues = new ContentValues(9);
    localContentValues.put("icontrol", Integer.valueOf(this.jdField_a_of_type_Int));
    localContentValues.put("ucount", Long.valueOf(this.jdField_a_of_type_Long));
    localContentValues.put("friendsNum", Integer.valueOf(this.jdField_b_of_type_Int));
    Parcel localParcel = Parcel.obtain();
    Object localObject = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = new QZoneCountUserInfo[this.jdField_a_of_type_JavaUtilArrayList.size()];
      localParcel.writeParcelableArray((Parcelable[])this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject), 0);
      localObject = localParcel.marshall();
    }
    localParcel.recycle();
    localContentValues.put("frienduins", (byte[])localObject);
    localContentValues.put("friendMsg", this.jdField_a_of_type_JavaLangString);
    localContentValues.put("trace_info", this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      localContentValues.put("existDL", Integer.valueOf(i));
      localContentValues.put("pushMsg", this.jdField_d_of_type_JavaLangString);
      localContentValues.put("schema", this.jdField_c_of_type_JavaLangString);
      localContentValues.put("iconUrl", this.e);
      localContentValues.put("showMsg", this.f);
      localContentValues.put("reportValue", this.g);
      localContentValues.put("cTime", Long.valueOf(this.jdField_b_of_type_Long));
      localContentValues.put("iShowLevel", Integer.valueOf(this.jdField_d_of_type_Int));
      if (!this.jdField_b_of_type_Boolean) {
        break label269;
      }
    }
    label269:
    for (int i = j;; i = 0)
    {
      localContentValues.put("hasShow", Integer.valueOf(i));
      return localContentValues;
      i = 0;
      break;
    }
  }
  
  public boolean a(bhbm parambhbm)
  {
    if (parambhbm == null) {}
    while (((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(parambhbm.jdField_b_of_type_JavaLangString))) || ((parambhbm.jdField_b_of_type_JavaLangString != null) && (!parambhbm.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) || ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals(parambhbm.jdField_d_of_type_JavaLangString))) || ((this.jdField_d_of_type_JavaLangString == null) && (parambhbm.jdField_d_of_type_JavaLangString != null)) || ((this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals(parambhbm.jdField_c_of_type_JavaLangString))) || ((this.jdField_c_of_type_JavaLangString == null) && (parambhbm.jdField_c_of_type_JavaLangString != null)) || (this.jdField_c_of_type_Int != parambhbm.jdField_c_of_type_Int) || (!String.valueOf(this.e).equals(String.valueOf(parambhbm.e))) || (!String.valueOf(this.f).equals(String.valueOf(parambhbm.f))) || (!String.valueOf(this.g).equals(String.valueOf(this.g))) || (this.jdField_b_of_type_Long != parambhbm.jdField_b_of_type_Long) || (this.jdField_a_of_type_Long != parambhbm.jdField_a_of_type_Long) || (!this.jdField_a_of_type_JavaUtilArrayList.equals(parambhbm.jdField_a_of_type_JavaUtilArrayList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbm
 * JD-Core Version:    0.7.0.1
 */