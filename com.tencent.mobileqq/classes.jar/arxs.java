import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arxs
{
  public int a;
  public long a;
  public arxw a;
  public String a;
  public arxw b;
  public String b;
  public String c;
  public String d;
  public String e;
  @notColumn
  public String f;
  
  public static arxs a(appoint_define.DateComment paramDateComment)
  {
    if ((paramDateComment == null) || (TextUtils.isEmpty(paramDateComment.str_comment_id.get()))) {
      return null;
    }
    arxs localarxs = new arxs();
    localarxs.jdField_a_of_type_JavaLangString = paramDateComment.str_comment_id.get();
    localarxs.jdField_b_of_type_JavaLangString = arxx.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
    localarxs.jdField_a_of_type_Long = paramDateComment.uint32_time.get();
    appoint_define.RichText localRichText;
    int i;
    if (paramDateComment.msg_content.has())
    {
      localRichText = (appoint_define.RichText)paramDateComment.msg_content.get();
      localarxs.c = a(localRichText);
      localarxs.jdField_a_of_type_Arxw = arxw.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      if (!paramDateComment.uint32_flag.has()) {
        break label220;
      }
      i = paramDateComment.uint32_flag.get();
      label131:
      localarxs.jdField_a_of_type_Int = i;
      if (!paramDateComment.msg_reply_info.has()) {
        break label225;
      }
    }
    label220:
    label225:
    for (paramDateComment = (appoint_define.ReplyInfo)paramDateComment.msg_reply_info.get();; paramDateComment = null)
    {
      if (paramDateComment != null)
      {
        localarxs.d = paramDateComment.str_comment_id.get();
        localarxs.jdField_b_of_type_Arxw = arxw.a((appoint_define.StrangerInfo)paramDateComment.msg_stranger_info.get());
      }
      localarxs.f = arxx.a(localarxs.jdField_a_of_type_Long, true);
      localarxs.e = arxx.a(localarxs.jdField_a_of_type_Long, false);
      return localarxs;
      localRichText = null;
      break;
      i = 0;
      break label131;
    }
  }
  
  public static arxs a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    arxs localarxs = new arxs();
    try
    {
      localarxs.jdField_a_of_type_JavaLangString = paramJSONObject.getString("commentId");
      localarxs.jdField_b_of_type_JavaLangString = paramJSONObject.getString("datingId");
      localarxs.c = paramJSONObject.getString("content");
      localarxs.jdField_a_of_type_Long = paramJSONObject.getLong("time");
      localarxs.jdField_a_of_type_Arxw = arxw.a(paramJSONObject.getJSONObject("puber"));
      localarxs.jdField_a_of_type_Int = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        for (;;)
        {
          localarxs.d = paramJSONObject.getString("replyId");
          try
          {
            localarxs.jdField_b_of_type_Arxw = arxw.a(paramJSONObject.getJSONObject("replyer"));
            return localarxs;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return localarxs;
          }
          localJSONException1 = localJSONException1;
          localJSONException1.printStackTrace();
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {}
    for (paramRichText = paramRichText.rpt_msg_elems.get(); (paramRichText == null) || (paramRichText.isEmpty()); paramRichText = null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramRichText.iterator();
    label135:
    label187:
    label190:
    label192:
    label195:
    while (localIterator.hasNext())
    {
      appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
      if (localElem != null)
      {
        if (localElem.str_content.has())
        {
          paramRichText = localElem.str_content.get();
          label106:
          localStringBuilder.append(paramRichText);
          if (!localElem.msg_face_info.has()) {
            break label187;
          }
          paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          if (paramRichText == null) {
            break label190;
          }
          if (!paramRichText.uint32_index.has()) {
            break label192;
          }
        }
        for (int i = paramRichText.uint32_index.get();; i = -1)
        {
          if (i < 0) {
            break label195;
          }
          localStringBuilder.append('\024');
          localStringBuilder.append((char)QQSysFaceUtil.convertToLocal(i));
          break;
          paramRichText = "";
          break label106;
          paramRichText = null;
          break label135;
          break;
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(List<arxs> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((arxs)paramList.next());
      if (localJSONObject == null) {
        break label83;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label83:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static JSONObject a(arxs paramarxs)
  {
    if (paramarxs == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramarxs.jdField_a_of_type_JavaLangString);
      localJSONObject.put("datingId", paramarxs.jdField_b_of_type_JavaLangString);
      localJSONObject.put("content", paramarxs.c);
      localJSONObject.put("time", paramarxs.jdField_a_of_type_Long);
      localJSONObject.put("replyId", paramarxs.d);
      localJSONObject.put("puber", arxw.a(paramarxs.jdField_a_of_type_Arxw));
      localJSONObject.put("replyer", arxw.a(paramarxs.jdField_b_of_type_Arxw));
      localJSONObject.put("flag", paramarxs.jdField_a_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException paramarxs)
    {
      paramarxs.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<arxs> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          arxs localarxs = a(paramString.getJSONObject(i));
          if (localarxs != null) {
            paramList.add(localarxs);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (arxs)paramObject;
    } while (((this.jdField_a_of_type_JavaLangString != null) || (paramObject.jdField_a_of_type_JavaLangString != null)) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString))));
    return true;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "".hashCode();
    }
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.c).append(",").append(this.jdField_a_of_type_Long).append(",").append(this.d).append(",").append(this.jdField_a_of_type_Arxw).append(",").append(this.jdField_b_of_type_Arxw).append(",").append(this.jdField_a_of_type_Int).append(",").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxs
 * JD-Core Version:    0.7.0.1
 */