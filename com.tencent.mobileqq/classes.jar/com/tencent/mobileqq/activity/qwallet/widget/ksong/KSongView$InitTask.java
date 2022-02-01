package com.tencent.mobileqq.activity.qwallet.widget.ksong;

import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class KSongView$InitTask
  extends AsyncTask<String, Void, KSHelper.Config>
{
  public KSongView$InitTask(KSongView paramKSongView) {}
  
  protected KSHelper.Config doInBackground(String... paramVarArgs)
  {
    String str = paramVarArgs[0];
    paramVarArgs = paramVarArgs[1];
    for (;;)
    {
      try
      {
        KSongView.access$402(this.this$0, KSongView.access$500(this.this$0, paramVarArgs));
        if ((KSongView.access$400(this.this$0) != null) && (KSongView.access$600(this.this$0, str)))
        {
          paramVarArgs = KSongView.access$400(this.this$0);
          return paramVarArgs;
        }
      }
      finally {}
      paramVarArgs = null;
    }
  }
  
  protected void onPostExecute(KSHelper.Config paramConfig)
  {
    boolean bool = false;
    if (paramConfig != null)
    {
      if (KSongView.access$700(this.this$0) != null) {
        KSongView.access$700(this.this$0).init(paramConfig);
      }
      KSongView.access$800(this.this$0).notifyDataSetChanged();
      KSongView.access$202(this.this$0, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + paramConfig);
    if (KSongView.access$300(this.this$0) != null)
    {
      KSHelper.KListener localKListener = KSongView.access$300(this.this$0);
      if (paramConfig != null) {
        bool = true;
      }
      localKListener.ready(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongView.InitTask
 * JD-Core Version:    0.7.0.1
 */