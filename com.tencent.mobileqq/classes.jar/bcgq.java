import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class bcgq
  extends bcga
{
  public bcgr a;
  public bcgs a;
  public ArrayList<bcgt> a;
  public boolean b;
  public boolean c;
  
  public bcgq(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public bcgq(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Long == 1003L)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (b() == null) {
        break label93;
      }
    }
    label93:
    for (paramView = b();; paramView = "")
    {
      bdll.b(localQQAppInterface, "dc00898", "", paramView, "auth_search", "clk_content", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_Boolean) {
        bdll.b(null, "dc00898", "", "", "0X800AC12", "0X800AC12", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("needRightCenter") != 1) {
          break label509;
        }
        bool = true;
        this.b = bool;
        JSONObject localJSONObject = paramString.optJSONObject("imageInfo");
        if (localJSONObject != null) {
          a(localJSONObject);
        }
        localJSONObject = paramString.optJSONObject("actionInfo");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_Bcgr = new bcgr(this);
          this.jdField_a_of_type_Bcgr.jdField_a_of_type_Int = localJSONObject.optInt("type");
          this.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("word");
          this.jdField_a_of_type_Bcgr.jdField_a_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
        }
        localJSONObject = paramString.optJSONObject("headIconInfo");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_Bcgs = new bcgs(this);
          this.jdField_a_of_type_Bcgs.jdField_a_of_type_Int = localJSONObject.optInt("type");
          this.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangString = localJSONObject.optString("iconUrl");
          this.jdField_a_of_type_Bcgs.jdField_b_of_type_Int = localJSONObject.optInt("iconWidth");
          this.jdField_a_of_type_Bcgs.c = localJSONObject.optInt("iconHeight");
          this.jdField_a_of_type_Bcgs.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagText");
          this.jdField_a_of_type_Bcgs.jdField_b_of_type_JavaLangString = localJSONObject.optString("tagBgColor");
        }
        paramString = paramString.optJSONArray("lineList");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            bcgt localbcgt;
            if (!TextUtils.isEmpty(localJSONObject.optString("word")))
            {
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localbcgt = new bcgt(this);
              localbcgt.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("word");
              localbcgt.jdField_a_of_type_JavaLangString = localJSONObject.optString("fontType", "A");
              localbcgt.jdField_a_of_type_Int = localJSONObject.optInt("maxLines");
              if (localJSONObject.optInt("needHighlight") != 1) {
                break label514;
              }
              bool = true;
              localbcgt.jdField_a_of_type_Boolean = bool;
              this.jdField_a_of_type_JavaUtilArrayList.add(localbcgt);
            }
            else if (localJSONObject.optJSONArray("words") != null)
            {
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localbcgt = new bcgt(this);
              localbcgt.jdField_a_of_type_JavaLangCharSequence = bcni.a(localJSONObject.optJSONArray("words"));
              localbcgt.jdField_a_of_type_JavaLangString = localJSONObject.optString("fontType", "A");
              localbcgt.jdField_a_of_type_Int = localJSONObject.optInt("maxLines");
              if (localJSONObject.optInt("needHighlight") == 1)
              {
                bool = true;
                localbcgt.jdField_a_of_type_Boolean = bool;
                this.jdField_a_of_type_JavaUtilArrayList.add(localbcgt);
              }
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 0, paramString.toString());
        }
      }
      return;
      boolean bool = false;
      continue;
      i += 1;
      continue;
      label509:
      bool = false;
      continue;
      label514:
      bool = false;
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgq
 * JD-Core Version:    0.7.0.1
 */