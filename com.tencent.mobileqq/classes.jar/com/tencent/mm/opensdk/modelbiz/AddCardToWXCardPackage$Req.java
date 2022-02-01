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
    Object localObject1 = this.cardArrary;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (this.cardArrary.size() > 40) {
        return false;
      }
      localObject1 = this.cardArrary.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AddCardToWXCardPackage.WXCardItem)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          String str = ((AddCardToWXCardPackage.WXCardItem)localObject2).cardId;
          if ((str != null) && (str.length() <= 1024))
          {
            localObject2 = ((AddCardToWXCardPackage.WXCardItem)localObject2).cardExtMsg;
            if ((localObject2 == null) || (((String)localObject2).length() <= 1024)) {
              continue;
            }
          }
        }
        return false;
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
        String str = ((AddCardToWXCardPackage.WXCardItem)localObject1).cardExtMsg;
        if (str == null) {
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
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Req.toBundle exception:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("MicroMsg.AddCardToWXCardPackage", ((StringBuilder)localObject2).toString());
    }
    paramBundle.putString("_wxapi_add_card_to_wx_card_list", localJSONStringer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Req
 * JD-Core Version:    0.7.0.1
 */