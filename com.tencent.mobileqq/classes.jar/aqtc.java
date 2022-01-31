import android.os.Bundle;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aqtc
  implements wiu
{
  public aqtc(UiApiPlugin paramUiApiPlugin, Map paramMap) {}
  
  public void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("action");
    if ("onCommentSend".equals(str)) {}
    Object localObject1;
    do
    {
      Object localObject2;
      Object localObject3;
      try
      {
        str = (String)this.jdField_a_of_type_JavaUtilMap.get(str);
        localObject1 = paramBundle.getString("commentId", "");
        localObject2 = paramBundle.getString("rowKey", "");
        localObject3 = paramBundle.getString("commentContent", "");
        int i = paramBundle.getInt("firstLevelComment");
        paramBundle = new JSONObject();
        paramBundle.put("commentId", localObject1);
        paramBundle.put("rowKey", localObject2);
        paramBundle.put("commentContent", localObject3);
        paramBundle.put("firstLevelComment", i + 1 + "");
        paramBundle.put("result", "success");
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { paramBundle.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if ("onCommentLike".equals(str)) {
        try
        {
          str = (String)this.jdField_a_of_type_JavaUtilMap.get(str);
          localObject1 = paramBundle.getString("commentId", "");
          localObject2 = paramBundle.getString("rowKey", "");
          paramBundle = paramBundle.getString("likeStatus", "");
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("commentId", localObject1);
          ((JSONObject)localObject3).put("rowKey", localObject2);
          ((JSONObject)localObject3).put("likeStatus", paramBundle);
          ((JSONObject)localObject3).put("result", "success");
          this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { ((JSONObject)localObject3).toString() });
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
      if ("onCommentDelete".equals(str)) {
        try
        {
          str = (String)this.jdField_a_of_type_JavaUtilMap.get(str);
          localObject1 = paramBundle.getString("commentId", "");
          paramBundle = paramBundle.getString("rowKey", "");
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("commentId", localObject1);
          ((JSONObject)localObject2).put("rowKey", paramBundle);
          ((JSONObject)localObject2).put("result", "success");
          this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
      }
    } while (!"onPanelClose".equals(str));
    try
    {
      str = (String)this.jdField_a_of_type_JavaUtilMap.get(str);
      paramBundle = paramBundle.getString("rowKey", "");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("rowKey", paramBundle);
      ((JSONObject)localObject1).put("result", "success");
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(str, new String[] { ((JSONObject)localObject1).toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqtc
 * JD-Core Version:    0.7.0.1
 */