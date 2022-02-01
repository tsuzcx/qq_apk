class atrf
  implements bevw
{
  atrf(atrd paramatrd) {}
  
  public void a(bevy parambevy, bevx parambevx)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100".equals(parambevx.a)) {
      atrd.a(this.a, parambevx, parambevy);
    }
    do
    {
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200".equals(parambevx.a))
      {
        atrd.b(this.a, parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500".equals(parambevx.a))
      {
        atrd.c(this.a, parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(parambevx.a))
      {
        atrd.d(this.a, parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200".equals(parambevx.a))
      {
        this.a.a(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000".equals(parambevx.a))
      {
        this.a.b(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(parambevx.a))
      {
        this.a.d(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(parambevx.a))
      {
        this.a.e(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100".equals(parambevx.a))
      {
        this.a.c(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900".equals(parambevx.a))
      {
        atrd.e(this.a, parambevx, parambevy);
        return;
      }
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(parambevx.a))
      {
        atrd.f(this.a, parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600".equals(parambevx.a))
      {
        this.a.g(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(parambevx.a))
      {
        this.a.f(parambevx, parambevy);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800".equals(parambevx.a))
      {
        atrd.g(this.a, parambevx, parambevy);
        return;
      }
      if ("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ".equals(parambevx.a))
      {
        atrd.h(this.a, parambevx, parambevy);
        return;
      }
    } while (!"OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400".equals(parambevx.a));
    atrd.i(this.a, parambevx, parambevy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atrf
 * JD-Core Version:    0.7.0.1
 */