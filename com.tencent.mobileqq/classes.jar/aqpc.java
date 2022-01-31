class aqpc
  implements barg
{
  aqpc(aqpa paramaqpa) {}
  
  public void a(bari parambari, barh parambarh)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500".equals(parambarh.a)) {
      aqpa.a(this.a, parambarh, parambari);
    }
    do
    {
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(parambarh.a))
      {
        aqpa.b(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200".equals(parambarh.a))
      {
        aqpa.c(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000".equals(parambarh.a))
      {
        aqpa.d(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(parambarh.a))
      {
        aqpa.e(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(parambarh.a))
      {
        aqpa.f(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100".equals(parambarh.a))
      {
        aqpa.g(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900".equals(parambarh.a))
      {
        aqpa.h(this.a, parambarh, parambari);
        return;
      }
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(parambarh.a))
      {
        aqpa.i(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600".equals(parambarh.a))
      {
        aqpa.j(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(parambarh.a))
      {
        aqpa.k(this.a, parambarh, parambari);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800".equals(parambarh.a))
      {
        aqpa.l(this.a, parambarh, parambari);
        return;
      }
      if ("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ".equals(parambarh.a))
      {
        aqpa.m(this.a, parambarh, parambari);
        return;
      }
    } while (!"OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400".equals(parambarh.a));
    aqpa.n(this.a, parambarh, parambari);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpc
 * JD-Core Version:    0.7.0.1
 */