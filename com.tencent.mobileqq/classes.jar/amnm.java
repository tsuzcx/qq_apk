import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.mobileqq.apollo.game.ApolloJSContext.1;
import com.tencent.mobileqq.apollo.game.ApolloJSContext.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

public class amnm
{
  private amns jdField_a_of_type_Amns;
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public String a;
  
  public amnm(String paramString)
  {
    this.jdField_a_of_type_Amns = new ApolloGameInterfaceProxy(this, paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    a("var newFun=Function;Function=function(){console.error(\"Function is disabled.\")};Function.prototype=newFun.prototype;newFun=undefined;", null);
    a("if(document&&document.createElement&&document.createElementNS){const _bk_createElement=document.createElement;const _bk_createElementNS=document.createElementNS;var bk_custom_proxy={};const bk_document_proxy=Object.freeze({createElement:function(){var result=null;if(bk_document_proxy.preCall(\"createElement\",arguments)){result=_bk_createElement.apply(document,arguments)}else{console.error(\"iframe is disabled\")}bk_document_proxy.postCall(\"createElement\",arguments);return result},createElementNS:function(){var result=null;if(bk_document_proxy.preCall(\"createElementNS\",arguments)){result=_bk_createElementNS.apply(document,arguments)}else{console.error(\"iframe is disabled\")}bk_document_proxy.postCall(\"createElementNS\",arguments);return result},preCall:function(fName,args){if(bk_custom_proxy&&bk_custom_proxy.preCall&&((typeof bk_custom_proxy.preCall)===\"function\")){bk_custom_proxy.preCall(fName,args)}if(fName){if(args&&args[0]){var itemName=args[0];if(typeof itemName===\"string\"){return itemName.indexOf(\"iframe\")===-1}}}return true},postCall:function(fName,args){if(bk_custom_proxy&&bk_custom_proxy.postCall&&((typeof bk_custom_proxy.postCall)===\"function\")){bk_custom_proxy.postCall(fName,args)}}});document.createElement=bk_document_proxy.createElement;document.createElementNS=bk_document_proxy.createElementNS};", null);
  }
  
  private void d()
  {
    a("(function(){var iframes=document.querySelectorAll(\"iframe\");for(var i=0;i<iframes.length;i++){var item=iframes[i];if(item.parentNode){item.parentNode.removeChild(item)}}})();", null);
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ApolloJSContext.1(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (amnl.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString2 = amnl.b(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJSContext", 1, "[notifyJSEVent] " + paramString1 + " " + paramString2);
      }
      a(String.format("if(window.__dispatchEvent){window.__dispatchEvent(%s,'%s','%s')}", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }), new amnn(this));
      return;
    }
    QLog.e("ApolloJSContext", 1, "[notifyJSEVent] game not running " + paramString1 + " " + paramString2);
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (this.jdField_a_of_type_Amns != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJSContext", 2, "register success");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      if (Build.VERSION.SDK_INT > 17)
      {
        paramCustomWebView.addJavascriptInterface(this.jdField_a_of_type_Amns, "__browserMsg");
        return;
      }
      paramCustomWebView.evaluateJavascript("window.__browserMsg =new function(){};window.__browserMsg.send=function(data,cmd){window.location='jsbridge://apolloGame/send?p='+JSON.stringify({dataStr:data,cmd:cmd});}\n", null);
      return;
    }
    QLog.e("ApolloJSContext", 1, "[registeJSContext] failed");
  }
  
  public void a(String paramString, ValueCallback<String> paramValueCallback)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) && (!TextUtils.isEmpty(paramString)))
    {
      ThreadManagerV2.getUIHandlerV2().post(new ApolloJSContext.2(this, paramString, paramValueCallback));
      return;
    }
    QLog.e("ApolloJSContext", 1, "[execScript] context is null");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Amns != null) && ((this.jdField_a_of_type_Amns instanceof ApolloGameInterfaceProxy))) {
      ((ApolloGameInterfaceProxy)this.jdField_a_of_type_Amns).send(paramString2, paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (a())) {
      c();
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!"Android.H5".equals(this.jdField_a_of_type_JavaLangString));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
    if ((this.jdField_a_of_type_Amns != null) && ((this.jdField_a_of_type_Amns instanceof ApolloGameInterfaceProxy))) {
      ((ApolloGameInterfaceProxy)this.jdField_a_of_type_Amns).h();
    }
    this.jdField_a_of_type_Amns = null;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Amns != null)
    {
      if (a())
      {
        if (!paramBoolean) {
          break label36;
        }
        a("if(window&&window.mqq&&window.mqq.ui&&!window.BK_SHARE){window.mqq.ui.shareArkMessageQzone=window.mqq.ui.shareArkMessage;window.mqq.ui.shareMessageQzone=window.mqq.ui.shareMessage;window.mqq.ui.shareArkMessage=shareToBK;window.mqq.ui.shareMessage=shareToBK}function shareToBK(shareObj,callback){window.__dispatchEvent=function(code,cmd,data){if(cmd===\"sc.share_game_to_friend_result.local\"){var tmpObj=JSON.parse(data);var result={retCode:(tmpObj.ret===0)?0:4};if(callback&&(typeof callback===\"function\")){callback(result);console.log(\"share success in bk\")}}};if(shareObj){var title=shareObj.title;var share_type=shareObj.share_type;var image_url=shareObj.image_url;var desc=shareObj.desc;var bg_url=shareObj.bg_url;var bk_url=shareObj.bk_url;var share_url=shareObj.share_url;if(share_url){share_url=share_url.substring(share_url.indexOf(\"?\")+1)}if(image_url&&!image_url.startsWith(\"http://\")&&!image_url.startsWith(\"https://\")){image_url=\"https://\"+image_url}if(bg_url&&!bg_url.startsWith(\"http://\")&&!bg_url.startsWith(\"https://\")){bg_url=\"https://\"+bg_url}if(!share_type){share_type=0}var share_ul=bk_url;if(!share_ul){share_url=bg_url}if(!share_ul){share_ul=image_url}var bkShare={inner:1,roomId:0,summary:desc,picUrl:share_ul,isSelectFriend:share_type===0?1:0,extendInfo:{bk_share_url:share_url},title:title};var command=\"cs.share_game_in_ark.local\";switch(share_type){case 0:break;default:command=\"cs.game_shell_share_callback.local\";break}window.__browserMsg.send(JSON.stringify(bkShare),command);return}};", null);
      }
      for (;;)
      {
        this.jdField_a_of_type_Amns.a(this);
        return;
        label36:
        d();
      }
    }
    QLog.e("ApolloJSContext", 1, "[onLoadFinish] interface null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnm
 * JD-Core Version:    0.7.0.1
 */