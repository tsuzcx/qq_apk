import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class bmwi
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
  
  public bmwi()
  {
    this(0, 0, new ArrayList(), "", "");
  }
  
  public bmwi(int paramInt1, int paramInt2, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, String paramString2)
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
  
  public bmwi(bmwi parambmwi)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = parambmwi.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = parambmwi.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (parambmwi.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(parambmwi.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaLangString = parambmwi.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = parambmwi.jdField_d_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = parambmwi.jdField_c_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambmwi.jdField_b_of_type_JavaLangString;
    this.e = parambmwi.e;
    this.jdField_c_of_type_Int = parambmwi.jdField_c_of_type_Int;
    this.f = parambmwi.f;
    this.g = parambmwi.g;
    this.jdField_b_of_type_Long = parambmwi.jdField_b_of_type_Long;
    this.jdField_d_of_type_Int = parambmwi.jdField_d_of_type_Int;
    this.jdField_b_of_type_Boolean = parambmwi.jdField_b_of_type_Boolean;
  }
  
  public static HashMap<Integer, bmwi> a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (paramCursor.moveToNext())
    {
      bmwi localbmwi = new bmwi();
      int j = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      localbmwi.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("icontrol"));
      localbmwi.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("friendMsg"));
      localbmwi.jdField_a_of_type_Long = paramCursor.getInt(paramCursor.getColumnIndex("ucount"));
      localbmwi.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("trace_info"));
      localbmwi.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("friendsNum"));
      localbmwi.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
            localbmwi.jdField_a_of_type_JavaUtilArrayList.add((QZoneCountUserInfo)localObject2);
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
        localbmwi.jdField_a_of_type_Boolean = bool;
        localbmwi.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("pushMsg"));
        localbmwi.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("schema"));
        localbmwi.e = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        localbmwi.g = paramCursor.getString(paramCursor.getColumnIndex("reportValue"));
        localbmwi.f = paramCursor.getString(paramCursor.getColumnIndex("showMsg"));
        localbmwi.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("countID"));
        localbmwi.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("cTime"));
        localbmwi.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("iShowLevel"));
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasShow")) != 1) {
          break label526;
        }
      }
      label526:
      for (boolean bool = true;; bool = false)
      {
        localbmwi.jdField_b_of_type_Boolean = bool;
        localHashMap.put(Integer.valueOf(j), localbmwi);
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
  
  public boolean a(bmwi parambmwi)
  {
    if (parambmwi == null) {}
    while (((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(parambmwi.jdField_b_of_type_JavaLangString))) || ((parambmwi.jdField_b_of_type_JavaLangString != null) && (!parambmwi.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) || ((this.jdField_d_of_type_JavaLangString != null) && (!this.jdField_d_of_type_JavaLangString.equals(parambmwi.jdField_d_of_type_JavaLangString))) || ((this.jdField_d_of_type_JavaLangString == null) && (parambmwi.jdField_d_of_type_JavaLangString != null)) || ((this.jdField_c_of_type_JavaLangString != null) && (!this.jdField_c_of_type_JavaLangString.equals(parambmwi.jdField_c_of_type_JavaLangString))) || ((this.jdField_c_of_type_JavaLangString == null) && (parambmwi.jdField_c_of_type_JavaLangString != null)) || (this.jdField_c_of_type_Int != parambmwi.jdField_c_of_type_Int) || (!String.valueOf(this.e).equals(String.valueOf(parambmwi.e))) || (!String.valueOf(this.f).equals(String.valueOf(parambmwi.f))) || (!String.valueOf(this.g).equals(String.valueOf(this.g))) || (this.jdField_b_of_type_Long != parambmwi.jdField_b_of_type_Long) || (this.jdField_a_of_type_Long != parambmwi.jdField_a_of_type_Long) || (!this.jdField_a_of_type_JavaUtilArrayList.equals(parambmwi.jdField_a_of_type_JavaUtilArrayList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwi
 * JD-Core Version:    0.7.0.1
 */