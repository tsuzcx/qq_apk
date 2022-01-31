package com.example.tissue;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

class MenuActivity$EventListener
  implements View.OnClickListener
{
  WeakReference<Context> ctxRef;
  
  MenuActivity$EventListener(Context paramContext)
  {
    this.ctxRef = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2130837508: 
      runV8TestDynamicContext();
      return;
    case 2130837507: 
      runV8Test();
      return;
    case 2130837506: 
      startFlutterApp1();
      return;
    case 2130837505: 
      startFlutter();
      return;
    }
    runV8MiniApp();
  }
  
  void runV8MiniApp()
  {
    Intent localIntent = new Intent((Context)this.ctxRef.get(), MiniAppActivity.class);
    ((Context)this.ctxRef.get()).startActivity(localIntent);
  }
  
  void runV8Test()
  {
    Object localObject = Engine.getInstance().initEngine(((Context)this.ctxRef.get()).getApplicationContext());
    if (((Engine)localObject).getStatus() == 0)
    {
      localObject = ((Engine)localObject).createJsRuntime();
      Engine.getIoExecutor().execute(new MenuActivity.EventListener.2(this, (V8JsRuntime)localObject));
      Logger.i("MenuActivity", "finished");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed:");
    localStringBuilder.append(((Engine)localObject).getStatus());
    Log.d("MenuActivity", localStringBuilder.toString());
  }
  
  void runV8TestDynamicContext()
  {
    Engine localEngine = Engine.getInstance().initEngine(((Context)this.ctxRef.get()).getApplicationContext());
    if (localEngine.getStatus() == 0)
    {
      int i = 0;
      while (i < 1)
      {
        new Thread(new MenuActivity.EventListener.1(this, localEngine)).start();
        i += 1;
      }
    }
  }
  
  void startFlutter()
  {
    Intent localIntent = new Intent((Context)this.ctxRef.get(), MainActivity.class);
    ((Context)this.ctxRef.get()).startActivity(localIntent);
  }
  
  void startFlutterApp1()
  {
    Intent localIntent = new Intent((Context)this.ctxRef.get(), MainActivity.class);
    localIntent.putExtra("OPEN_MINIPROGRAM_NAME", "QIANDAO");
    ((Context)this.ctxRef.get()).startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MenuActivity.EventListener
 * JD-Core Version:    0.7.0.1
 */