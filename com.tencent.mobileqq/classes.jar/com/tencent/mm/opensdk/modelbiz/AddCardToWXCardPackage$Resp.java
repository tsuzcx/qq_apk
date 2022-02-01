package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class AddCardToWXCardPackage$Resp
  extends BaseResp
{
  public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
  
  public AddCardToWXCardPackage$Resp() {}
  
  public AddCardToWXCardPackage$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public boolean checkArgs()
  {
    List localList = this.cardArrary;
    return (localList != null) && (localList.size() != 0);
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    if (this.cardArrary == null) {
      this.cardArrary = new LinkedList();
    }
    paramBundle = paramBundle.getString("_wxapi_add_card_to_wx_card_list");
    if ((paramBundle != null) && (paramBundle.length() > 0)) {}
    try
    {
      paramBundle = ((JSONObject)new JSONTokener(paramBundle).nextValue()).getJSONArray("card_list");
      int i = 0;
      while (i < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(i);
        AddCardToWXCardPackage.WXCardItem localWXCardItem = new AddCardToWXCardPackage.WXCardItem();
        localWXCardItem.cardId = localJSONObject.optString("card_id");
        localWXCardItem.cardExtMsg = localJSONObject.optString("card_ext");
        localWXCardItem.cardState = localJSONObject.optInt("is_succ");
        this.cardArrary.add(localWXCardItem);
        i += 1;
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  public int getType()
  {
    return 9;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    JSONStringer localJSONStringer = new JSONStringer();
    try
    {
      localJSONStringer.object();
      localJSONStringer.key("card_list");
      localJSONStringer.array();
      localObject = this.cardArrary.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AddCardToWXCardPackage.WXCardItem localWXCardItem = (AddCardToWXCardPackage.WXCardItem)((Iterator)localObject).next();
        localJSONStringer.object();
        localJSONStringer.key("card_id");
        localJSONStringer.value(localWXCardItem.cardId);
        localJSONStringer.key("card_ext");
        String str;
        if (localWXCardItem.cardExtMsg == null) {
          str = "";
        } else {
          str = localWXCardItem.cardExtMsg;
        }
        localJSONStringer.value(str);
        localJSONStringer.key("is_succ");
        localJSONStringer.value(localWXCardItem.cardState);
        localJSONStringer.endObject();
      }
      localJSONStringer.endArray();
      localJSONStringer.endObject();
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder("Resp.toBundle exception:");
      ((StringBuilder)localObject).append(localException.getMessage());
      Log.e("MicroMsg.AddCardToWXCardPackage", ((StringBuilder)localObject).toString());
    }
    paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp
 * JD-Core Version:    0.7.0.1
 */