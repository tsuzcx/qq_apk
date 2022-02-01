package com.tencent.biz.webviewplugin;

import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import org.json.JSONObject;

class HotchatPlugin$7
  implements PopupMenuDialog.OnClickActionListener
{
  HotchatPlugin$7(HotchatPlugin paramHotchatPlugin, String paramString) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = paramMenuItem.id;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      try
      {
        localJSONObject.put("index", 1);
        this.b.callJs(this.a, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramMenuItem)
      {
        paramMenuItem.printStackTrace();
        return;
      }
    }
    try
    {
      localJSONObject.put("index", 0);
      this.b.callJs(this.a, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramMenuItem)
    {
      paramMenuItem.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin.7
 * JD-Core Version:    0.7.0.1
 */