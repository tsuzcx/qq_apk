import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class blso
  implements Cloneable
{
  public int a;
  public String a;
  public List<MusicItemInfo> a;
  public boolean a;
  public boolean b = true;
  
  public blso() {}
  
  public blso(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("categoryName")) {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("categoryName");
    }
    if (paramJSONObject.has("tagid")) {
      this.jdField_a_of_type_Int = paramJSONObject.getInt("tagid");
    }
    if (paramJSONObject.has("enabled")) {
      this.b = paramJSONObject.getBoolean("enabled");
    }
    this.jdField_a_of_type_Boolean = "1".equals(paramJSONObject.optString("random_position"));
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        MusicItemInfo localMusicItemInfo = new MusicItemInfo(paramJSONObject.optString(i));
        localMusicItemInfo.mTagName = this.jdField_a_of_type_JavaLangString;
        if (localMusicItemInfo.isWsBanner()) {}
        localArrayList.add(localMusicItemInfo);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList = localArrayList;
    }
  }
  
  public blso a()
  {
    try
    {
      blso localblso = (blso)super.clone();
      return localblso;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public MusicItemInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MusicItemInfo localMusicItemInfo = (MusicItemInfo)localIterator.next();
        if (localMusicItemInfo.mItemId == paramInt) {
          return localMusicItemInfo;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blso
 * JD-Core Version:    0.7.0.1
 */