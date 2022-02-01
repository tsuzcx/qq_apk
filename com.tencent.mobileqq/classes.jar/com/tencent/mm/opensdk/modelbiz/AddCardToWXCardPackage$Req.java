package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

public class AddCardToWXCardPackage$Req
  extends BaseReq
{
  public List<AddCardToWXCardPackage.WXCardItem> cardArrary;
  
  public boolean checkArgs()
  {
    Object localObject = this.cardArrary;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (this.cardArrary.size() > 40) {
        return false;
      }
      localObject = this.cardArrary.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AddCardToWXCardPackage.WXCardItem localWXCardItem = (AddCardToWXCardPackage.WXCardItem)((Iterator)localObject).next();
        if ((localWXCardItem == null) || (localWXCardItem.cardId == null) || (localWXCardItem.cardId.length() > 1024) || ((localWXCardItem.cardExtMsg != null) && (localWXCardItem.cardExtMsg.length() > 1024))) {
          return false;
        }
      }
      return true;
    }
    return false;
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
      localObject2 = this.cardArrary.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (AddCardToWXCardPackage.WXCardItem)((Iterator)localObject2).next();
        localJSONStringer.object();
        localJSONStringer.key("card_id");
        localJSONStringer.value(((AddCardToWXCardPackage.WXCardItem)localObject1).cardId);
        localJSONStringer.key("card_ext");
        if (((AddCardToWXCardPackage.WXCardItem)localObject1).cardExtMsg == null) {
          localObject1 = "";
        } else {
          localObject1 = ((AddCardToWXCardPackage.WXCardItem)localObject1).cardExtMsg;
        }
        localJSONStringer.value(localObject1);
        localJSONStringer.endObject();
      }
      localJSONStringer.endArray();
      localJSONStringer.endObject();
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder("Req.toBundle exception:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("MicroMsg.AddCardToWXCardPackage", ((StringBuilder)localObject2).toString());
    }
    paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Req
 * JD-Core Version:    0.7.0.1
 */