package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$3$1
  extends PTSOfflineUtil.PTSOfflineAsyncBack
{
  PTSJSCLoader$3$1(PTSJSCLoader.3 param3) {}
  
  public void loaded(String paramString, int paramInt)
  {
    super.loaded(paramString, paramInt);
    QLog.i("PTSJSCLoader", 1, "[updatePTSJSC], asyncBack code = " + paramInt + ", param = " + paramString);
    if ((paramInt == 0) && (paramString == null))
    {
      QLog.i("PTSJSCLoader", 1, "[updatePTSJSC], handleDownloadPTSJSC, download succeed.");
      PTSJSCLoader.b(this.a.this$0);
    }
  }
  
  public void progress(int paramInt)
  {
    super.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader.3.1
 * JD-Core Version:    0.7.0.1
 */