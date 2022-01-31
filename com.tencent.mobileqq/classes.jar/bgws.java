public class bgws
{
  public String biz_params;
  public String bus_type;
  public String people_num;
  public String pick_entry;
  public String recv_type;
  
  public String toString()
  {
    return new StringBuilder().append("people_num: ").append(this.people_num).toString() + new StringBuilder().append("recv_type: ").append(this.recv_type).toString() + new StringBuilder().append("bus_type: ").append(this.bus_type).toString() + new StringBuilder().append("pick_entry: ").append(this.pick_entry).toString() + new StringBuilder().append("biz_params: ").append(this.biz_params).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgws
 * JD-Core Version:    0.7.0.1
 */